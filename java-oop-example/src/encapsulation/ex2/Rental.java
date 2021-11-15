package encapsulation.ex2;

public class Rental {
    private Movie movie;
    private int daysRented;

    public int getFrequentRenterPoints() {
        // as-is
//        if (movie.getPriceCode() == Movie.NEW_RELEASE && daysRented > 1) {
//            return 2;
//        } else {
//            return 1;
//        }

        // to-be
        return movie.getFrequentRenterPoints(daysRented);
    }
}
