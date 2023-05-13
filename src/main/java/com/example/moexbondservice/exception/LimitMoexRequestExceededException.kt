package com.example.moexbondservice.exception

class LimitMoexRequestExceededException(exceededLimitsOfMoexRequests: String?) :
    RuntimeException(exceededLimitsOfMoexRequests)
