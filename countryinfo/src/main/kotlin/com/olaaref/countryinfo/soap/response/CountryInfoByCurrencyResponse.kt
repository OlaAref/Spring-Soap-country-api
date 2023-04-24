package com.olaaref.countryinfo.soap.response

/**
 * A data class representing a response containing information about a country that uses a specific currency.
 *
 * This class represents a response containing information about a country that uses a specific currency.
 * It includes the ISO code and name of the country. It is typically used as a return type for
 * methods or endpoints that retrieve information about countries that use a specific currency.
 *
 * @param code The ISO code of the country.
 * @param name The name of the country.
 */
data class CountryInfoByCurrencyResponse(val code: String,
                                         val name: String)
