package az.edu.turing.module02.movieapp;

import java.util.Scanner;

public class MovieApp {
    public static void main(String[] args) {
        System.out.println("Welcome, please enter a number between 0 and 8");
        Scanner sc = new Scanner(System.in);
        Movie[] movies = new Movie[999];
        int movieCount = 0;
        boolean end = false;
        while (true) {
            if (end) {
                System.out.println("See ya");
                break;
            }
            printMenu();
            if (sc.hasNextInt()) {
                int n = sc.nextInt();
                switch (n) {
                    case 0:
                        end = true;
                        break;
                    case 1:
                        movieCount = inputMovie(sc, movies, movieCount, 3);
                        break;
                    case 2:
                        displayList(movies);
                        break;
                    case 3:
                        System.out.println("How many movies do you want to add?");
                        int addCount = sc.nextInt();
                        movieCount = inputMovie(sc, movies, movieCount, addCount);
                        break;
                    case 4:
                        displayStatistics(movies, movieCount);
                        break;
                    case 5:
                        System.out.println("What movie do you want to search?");
                        sc.nextLine();
                        String name = sc.nextLine();
                        searchMovie(name, movies);
                        break;
                    case 6:
                        updateRating(sc, movies);
                        break;
                    case 7:
                        deleteMovie(sc, movies);
                        break;
                    case 8:
                        sortMovies(movies);
                        break;
                    default:
                        System.out.println("Please enter a number between 0 and 8");
                        break;
                }
            } else {
                System.out.println("Please enter a valid number");
                sc.nextLine();
            }
        }
    }

    public static void printMenu() {
        System.out.println("""
                0: Exit\
                
                1: Input 3 movies\
                
                2: Display the list of the movies and their ratings\
                
                3: Input more or less movies\
                
                4: Find statistics\
                
                5: Search a movie\
                
                6: Update the rating of a movie\
                
                7: Delete a movie\
                
                8: Sort movies""");
    }

    public static void displayList(Movie[] movies) {
        boolean exist = false;
        for (Movie movie : movies) {
            if (movie != null) {
                System.out.println(movie);
                exist = true;
            }
        }
        if (!exist) {
            System.out.println("No movies found");
        }
    }

    public static int inputMovie(Scanner sc, Movie[] movies, int movieCount, int addCount) {
        for (int i = 0; i < addCount; i++) {
            System.out.println("Enter the name of the movie: ");
            sc.nextLine();
            String name = checkValidString(sc);
            System.out.println("Enter the rating: ");
            double rating = checkValidDouble(sc);
            movies[movieCount] = new Movie(name, rating);
            movieCount++;
        }
        return movieCount;
    }

    public static void displayStatistics(Movie[] movies, int movieCount) {
        if (movieCount == 0) {
            System.out.println("No movies found");
            return;
        }
        int i = 0;
        while (movies[i] == null) i++;
        double maxRating = movies[i].getRating();
        double minRating = movies[i].getRating();
        double avgRating = movies[i].getRating();
        String maxMovie = movies[i].getName();
        String minMovie = movies[i].getName();
        for (int j = i + 1; j < movies.length; j++) {
            if (movies[j] != null) {
                if (movies[j].getRating() > maxRating) {
                    maxRating = movies[j].getRating();
                    maxMovie = movies[j].getName();
                }
                if (movies[j].getRating() < minRating) {
                    minRating = movies[j].getRating();
                    minMovie = movies[j].getName();
                }
                avgRating += movies[j].getRating();
            }
        }
        System.out.println("Movie with maximum rating:" + maxMovie);
        System.out.println("Movie with minimum rating: " + minMovie);
        System.out.println("Average rating of the movies: " + avgRating / movieCount);
        System.out.println(movieCount);
    }

    public static Movie searchMovie(String name, Movie[] movies) {
        for (Movie movie : movies) {
            if (movie != null) {
                if (movie.getName().equalsIgnoreCase(name)) {
                    System.out.println(movie);
                    return movie;
                }
            }
        }
        System.out.println("Movie not found.");
        return null;
    }

    public static void updateRating(Scanner sc, Movie[] movies) {
        System.out.println("What movie do you want to update?");
        sc.nextLine();
        String name = checkValidString(sc);
        Movie movie = searchMovie(name, movies);
        if (movie != null) {
            System.out.println("Enter the rating: ");
            movie.setRating(sc.nextDouble());
        } else {
            System.out.println("Movie not found.");
        }
    }

    public static void deleteMovie(Scanner sc, Movie[] movies) {
        System.out.println("What movie do you want to delete?");
        sc.nextLine();
        String name = checkValidString(sc);
        for (int i = 0; i < movies.length; i++) {
            if (movies[i] != null) {
                if (movies[i].getName().equalsIgnoreCase(name)) {
                    movies[i] = null;
                    System.out.println("Movie deleted.");
                    return;
                }
            }
        }
        System.out.println("Movie not found");
    }

    public static void sortMovies(Movie[] movies) {
        for (int i = 0; i < movies.length; i++) {
            for (int j = i + 1; j < movies.length; j++) {
                if (movies[i] != null && movies[j] != null) {
                    if (movies[i].getRating() > movies[j].getRating()) {
                        Movie temp = movies[i];
                        movies[i] = movies[j];
                        movies[j] = temp;
                    }
                }
            }
        }
        for (Movie movie : movies) {
            if (movie != null) {
                System.out.println(movie);
            }
        }
    }

    public static String checkValidString(Scanner sc) {
        if (sc.hasNextLine()) {
            return sc.nextLine();
        }
        System.out.println("Please enter a valid string");
        return checkValidString(sc);
    }

    public static double checkValidDouble(Scanner sc) {
        if (sc.hasNextDouble()) {
            double rating = sc.nextDouble();
            if (rating >= 0 && rating <= 10) {
                return rating;
            }
        }
        System.out.println("Please enter a valid number between 0 and 10.0");
        return checkValidDouble(sc);
    }

}
