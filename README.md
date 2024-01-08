# Netflix Clone Application

## Project Overview

Welcome to the documentation for the Netflix Clone Application, a Java-based project designed to provide a user-friendly interface for searching, displaying, and exploring movie details. This documentation focuses on both backend and frontend features.

### Table of Contents

1. [Project Overview](#project-overview)
2. [Backend Features](#Key-Backend-Features)
   - [OMDb Website Integration](#omdb-website-integration)
   - [JSON Handling and Searching](#JSON-Handling-and-Searching)
3. [Frontend Features](#Key-frontend-features)
   - [Scene1: Movie Search and Display](#scene1-movie-search-and-display)
   - [Scene2: Detailed Movie Information](#scene2-detailed-movie-information)
4. [Sample Images](#Sample-Images)
5. [How to Use](#how-to-use)
6. [Dependencies](#dependencies)
7. [Contributions](#contributions)
8. [License](#license)

## Project Overview

The Netflix Clone Application is a Java-based project that utilizes the OMDb website to fetch movie data. It offers a seamless user interface for interacting with the application, featuring frontend components built using JavaFX and backend logic for handling Website requests.

## Key Backend Features

### OMDb Website Integration

The backend of the Netflix Clone Application integrates with the OMDb website to fetch detailed information about movies. The application sends HTTP requests to the OMDb Website based on user input, retrieves JSON responses, and processes the data for display in the frontend.

### JSON Handling and Searching

In the `Scene1_Controller` class, JSON handling and search functionality play a pivotal role in dynamically updating the movie list based on user input. Here are the key components:

- **JSON Handling:**
  - The `getjson(String link)` method handles the retrieval and parsing of JSON data from the OMDb Website. It uses a `URL` object to connect to the Website and a `JSONParser` to parse the JSON response into a `JSONObject`.
  - The `addMovie()` and `addMovie(String s)` methods utilize the `getjson` method to fetch movie details from the OMDb Website based on the user's search input. The retrieved JSON response is then used to create a new `MoviePane` representing the movie.

## Key Frontend Features

### Scene1: Movie Search and Display

Scene1 serves as the primary interface for users to interact with the application. Key features include:

- **Search Bar:** Users can input movie titles to search for information.
- **Add Button:** Allows users to add a movie to the display based on the entered search query.
- **Delete Button:** Enables users to remove the most recently added movie from the display based on the last entered search query.
- **Movie Display:** A TilePane dynamically shows MoviePanes representing each added movie.
- **Scrolling:** A ScrollPane enables easy navigation through the displayed movies.
- **Real-time Search:** Users can press Enter to initiate a search in real-time.

### Scene2: Detailed Movie Information

Scene2 provides detailed information about a selected movie, including:

- **Title and Overview:** Displays the movie title and a brief overview of the plot.
- **Genres:** Presents the movie genres in a visually appealing manner.
- **Additional Details:** Includes information such as MPAA Rating, runtime, language, release date, and awards.
- **Poster Image:** Displays the movie poster image.
- **Navigation:** Users can easily switch back to Scene1 to explore more movies.

## Sample Images

![Movie Display](https://raw.githubusercontent.com/Se3do/Netflix-Clone/main/NetflixClone/Preview/image%20(1).png)

*1 - Showcasing the Movie Display interface.*

![Movie Display](https://raw.githubusercontent.com/Se3do/Netflix-Clone/main/NetflixClone/Preview/image%20(3).png)

*2 - Showcasing Detailed Movie interface.*

## How to Use

1. **Clone the repository:** `git clone https://github.com/Se3do/Netflix-Clone-Application.git`
2. **Open the project:** In your preferred Java development environment.
3. **Run the application:** Execute Main.java to start the application.

## Dependencies

- **JavaFX:** Ensure that your development environment is configured to include the JavaFX library.
  
- **JSON Simple Library:** This project utilizes the JSON Simple library for handling JSON data from the OMDb Website. Make sure that your development enviroment is configured to include the JSON Simple Library


## Contributions

Contributions to the project are welcome. If you have any suggestions, improvements, or bug fixes, feel free to submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE). See the LICENSE file for more details.

Feel free to enhance this documentation with additional information as needed for your specific project.

