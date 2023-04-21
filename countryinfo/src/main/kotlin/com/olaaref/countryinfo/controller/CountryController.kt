package com.olaaref.countryinfo.controller

import com.olaaref.countryinfo.service.CountryService
import com.olaaref.countryinfo.soap.response.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("country")
class CountryController @Autowired constructor(private val countryService: CountryService) {

    @GetMapping("/{code}/capital")
    fun getCapitalCity(@PathVariable("code") code: String): String? = countryService.getCapitalCity(code)

    @GetMapping("/currency-code/{currencyCode}")
    fun getCountryByCurrency(@PathVariable("currencyCode") currencyCode: String): List<CountryInfoByCurrencyResponse>? =
        countryService.getCountryByCurrency(currencyCode)

    @GetMapping("/{code}/currency")
    fun getCurrency(@PathVariable("code") countryCode: String): CountryInfoCurrencyResponse? =
        countryService.getCurrency(countryCode)

    @GetMapping("/{code}/phone")
    fun getPhoneCode(@PathVariable("code") countryCode: String): String? = countryService.getPhoneCode(countryCode)

    @GetMapping("/name/{name}")
    fun getCountryCode(@PathVariable("name") countryName: String): String{
        return countryService.getCountryCode(countryName)
    }

    @GetMapping("/{code}/name")
    fun getCountryNameByCode(@PathVariable("code") countryCode: String): String? =
        countryService.getCountryNameByCode(countryCode)

    @GetMapping("/currency/currency-code/{currencyCode}")
    fun getCurrencyByCode(@PathVariable("currencyCode") currencyCode: String): String? =
        countryService.getCurrencyByCode(currencyCode)

    @GetMapping("/{code}/full/info")
    fun getFullCountryInfo(@PathVariable("code") countryCode: String): FullCountryInformationRespone? =
        countryService.getFullCountryInfo(countryCode)

    @GetMapping("/all")
    fun getAllCountries(): List<FullCountryInformationRespone>? =
        countryService.getAllCountries()

    @GetMapping("/language/lang-name/{langName}")
    fun getLanguageCode(@PathVariable("langName") languageName: String): String? =
        countryService.getLanguageCode(languageName)

    @GetMapping("/language/lang-code/{langeCode}")
    fun getLanguageName(@PathVariable("langeCode") languageCode: String): String? =
        countryService.getLanguageName(languageCode)

    @GetMapping("/continents")
    fun getAllContinents(): List<ContinentResponse>? =
        countryService.getAllContinents()

    @GetMapping("/currencies")
    fun getAllCurrencies(): List<CurrencyResponse>? =
        countryService.getAllCurrencies()

    @GetMapping("/languages")
    fun getAllLanguages(): List<LanguageResponse>? =
        countryService.getAllLanguages()
}