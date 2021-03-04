ISS-International-Space-Station

Brief description of the system¶ The project should create an application which showcases information about the movement of the International Space Station (ISS).

Main system functions ISS traffic data download from the relevant web service Processing of downloaded data on the application side Downloaded data should be saved to the database Technologies Console application JDBC or Hibernate Domain logic divided into layers, eg DAO, Service Unit testing tools Optionally:

Http client, e.g. HttpClient, OkHttp Application presentation layer based on a pattern, eg MVC/MVP JSON data serialization/deserialization tool, eg Gson, Jackson dependency injection framework, such as Guice JavaFX based frontend Functionalities User Interface As part of the console/graphical view, the user should be able to select one of the following options:

ISS speed calculation returning a list of upcoming ISS runs for a specific location returning the number of people in space within the ISS API integration The functionality of the application should be based on the API: http://open-notify.org/Open-Notify-API

If you don't want to use HTTP protocol, generate data and save it in external files (use CSV or JSON format). Example data (in JSON format) can be found here: http://api.open-notify.org/iss-now.json.

ISS speed calculation The user should be informed about the ISS speed on the basis of two readings using the API http://open-notify.org/Open-Notify-API/ISS-Location-Now/. The calculated speed should be saved to the database.

Get a list of upcoming ISS runs for a specific location By selecting this option, the user should be able to see the current list of upcoming ISS runs for a specific location, using the API http://open-notify.org/Open-Notify-API/ISS-Pass-Times/. Data should be written to the database. The entered location should be validated in accordance with the guidelines described in the documentation.

Report the number of people in space within the ISS The user selecting this option should be able to see the current list of people in space as part of the space mission, using the API http://open-notify.org/Open-Notify-API/People-In-Space/. Data should be written to the database.

Optional functionalities Statistic data The user should be able to calculate, e.g.:

average speed over a specific period of time, e.g. month, year. These calculations should be based on the current records from the database how many times the ISS has been over a given location in the time interval number of people on the ISS space mission Visualisation¶ As part of the graphical interface, implement a mechanism that displays the current currentPosition of the ISS on the world map.

Data write/read The user should be able to save the currently collected data to a file in any format, and then restore them by saving directly to the database.

Unit tests The implemented functionalities should be covered with unit tests in accordance with commonly used methodologies and practices.

Additional requirements The program should meet the following criteria:

functionality code quality (transparency, maintainability, structure) use of the latest technologies (at least the latest stable version of JDK, the latest stable versions of libraries) user experience reliability The task is formulated very generally on purpose. If something is not specified, it can be implemented in a way that is convenient for the student. There are no preferred solutions or technologies other than those listed.
