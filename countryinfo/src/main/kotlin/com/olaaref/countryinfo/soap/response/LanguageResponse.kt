package com.olaaref.countryinfo.soap.response

/**
 * A data class representing a response containing information about a language.
 *
 * This class represents a response containing information about a language, including its ISO code
 * and name. It is typically used as a return type for methods or endpoints that retrieve information
 * about a language.
 *
 * @param languageCode The ISO code of the language.
 * @param languageName The name of the language.
 */
data class LanguageResponse(val languageCode: String,
                            val languageName: String)
