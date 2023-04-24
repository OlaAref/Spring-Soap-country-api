package com.olaaref.countryinfo.soap.response

/**
 * A data class representing a response containing the capital city of a country.
 *
 * This class represents a response containing the capital city of a country. It is typically used
 * as a return type for methods or endpoints that retrieve information about a country's capital city.
 *
 * @param capitalCity The name of the country's capital city.
 */
data class CountryCapitalCityResponse(var capitalCity: String)
