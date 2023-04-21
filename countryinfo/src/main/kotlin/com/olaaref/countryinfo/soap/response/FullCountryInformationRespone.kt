package com.olaaref.countryinfo.soap.response

data class FullCountryInformationRespone(val countryCode: String,
                                         val countryName: String,
                                         val capitalCity: String,
                                         val phoneCode: String,
                                         val continentCode: String,
                                         val currencyCode: String,
                                         val countryFlag: String,
                                         val languages: List<LanguageResponse>)
