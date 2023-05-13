package com.example.moexbondservice.service.utils

import com.example.moexbondservice.dto.BondDto
import com.example.moexbondservice.exception.BondParsingException
import mu.KotlinLogging
import org.springframework.stereotype.Component
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.xml.sax.InputSource
import java.io.StringReader
import java.math.BigDecimal
import javax.xml.XMLConstants
import javax.xml.parsers.DocumentBuilderFactory

@Component
class MoexBondXmlParser : BondParser {
    private val log = KotlinLogging.logger{}
    override fun parse(ratesAsString: String?): List<BondDto> {
        val bonds = ArrayList<BondDto>()
        val dbf = DocumentBuilderFactory.newInstance()
        dbf.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "")
        dbf.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "")
        try {
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true)
            val db = dbf.newDocumentBuilder()
            ratesAsString?.let {
                StringReader(it).use { reader ->
                    val doc = db.parse(InputSource(reader))
                    doc.documentElement.normalize()
                    val list = doc.getElementsByTagName("row")
                    for (rowIdx in 0 until list.length) {
                        val node = list.item(rowIdx)
                        if (node.nodeType == Node.ELEMENT_NODE) {
                            val element = node as Element
                            val ticker = element.getAttribute("SECID")
                            val price = element.getAttribute("PREVADMITTEDQUOTE")
                            val name = element.getAttribute("SHORTNAME")
                            if (ticker.isNotEmpty() && price.isNotEmpty() && name.isNotEmpty()) {
                                bonds.add(BondDto(ticker, name, BigDecimal.valueOf(price.toLong())))
                            }
                        }
                    }
                }
            }
        } catch (ex: Exception) {
            log.error("xml parsing error, xml:{}", ratesAsString, ex)
            throw BondParsingException(ex)
        }
        return bonds
    }
}
