
# Spring Country SOAP Client

This is a Spring-based SOAP client that consumes a SOAP web service to retrieve information about countries, including their ISO codes, names, capital cities, phone codes, currencies, and languages.

## Table of Contents

-   Getting Started
-   Usage
-   License

## Getting Started

To get started with the project, you can clone the repository from GitHub:

```
git clone https://github.com/OlaAref/Spring-country-Soap-client.git

```

The project requires Java 8 or later and uses the Gradle build system. To build the project, navigate to the project directory and run the following command:

```
./gradlew build

```

This will download the required dependencies and build the project. You can then run the project using the following command:

```
./gradlew bootRun

```

This will start the Spring Boot application and make it available at `http://localhost:8080`.

## Usage

Once the application is running, you can use it to retrieve information about countries via SOAP web services. The following endpoints are available:

-   `/country/all`: Retrieves a list of all countries and their basic information, including ISO code and name.
-   `/country/{countryCode}/capital`: Retrieves the capital city of the country with the specified ISO code.
-   `/country/currency/currency-code/{currencyCode}`: Retrieves a list of countries that use the specified currency, including their ISO codes and names.
-   `/country/{code}/full/info`: Retrieves comprehensive information about the country with the specified ISO code, including its name, capital city, phone code, continent code, currency code, flag image URL, and a list of languages spoken in the country.

You can use any HTTP client, such as `curl` or Postman, to make requests to these endpoints. For example, to retrieve the capital city of Egypt, you can make a GET request to:

```
http://localhost:8080/countries/capital/EG

```

This will return a JSON response containing the capital city of Egypt.


## License

This project is licensed under the MIT License. See the LICENSE file for details.

