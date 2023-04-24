package com.olaaref.countryinfo.soap.response

/**
 * A data class representing a response containing information about a currency.
 *
 * This class represents a response containing information about a currency, including its ISO code
 * and name. It is typically used as a return type for methods or endpoints that retrieve information
 * about a currency.
 *
 * @param currencyCode The ISO code of the currency.
 * @param currencyName The name of the currency.
 */
data class CurrencyResponse (val currencyCode: String,
                             val currencyName: String)
