package com.olaaref.countryinfo.soap.response

/**
 * A data class representing a response containing information about a continent.
 *
 * This class represents a response containing information about a continent, including its ISO code
 * and name. It is typically used as a return type for methods or endpoints that retrieve information
 * about continents.
 *
 * @param continentCode The ISO code of the continent.
 * @param continentName The name of the continent.
 */
data class ContinentResponse(val continentCode: String,
                             val continentName: String)
