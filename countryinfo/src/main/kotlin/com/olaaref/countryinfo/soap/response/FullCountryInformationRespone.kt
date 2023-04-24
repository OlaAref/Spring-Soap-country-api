package com.olaaref.countryinfo.soap.response

/**
 * A data class representing a response containing comprehensive information about a country.
 *
 * This class represents a response containing comprehensive information about a country, including
 * its ISO code, name, capital city, phone code, continent code, currency code, flag image URL, and a
 * list of languages spoken in the country. It is typically used as a return type for methods or endpoints
 * that retrieve comprehensive information about a country.
 *
 * @param countryCode The ISO code of the country.
 * @param countryName The name of the country.
 * @param capitalCity The name of the country's capital city.
 * @param phoneCode The country's phone code.
 * @param continentCode The ISO code of the continent the country belongs to.
 * @param currencyCode The ISO code of the currency used in the country.
 * @param countryFlag The URL of the country's flag image.
 * @param languages A list of LanguageResponse objects representing the languages spoken in the country.
 */
data class FullCountryInformationRespone(val countryCode: String,
                                         val countryName: String,
                                         val capitalCity: String,
                                         val phoneCode: String,
                                         val continentCode: String,
                                         val currencyCode: String,
                                         val countryFlag: String,
                                         val languages: List<LanguageResponse>)
