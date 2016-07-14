package es.jagr.model;

/**
 * The model for recipe
 */
public class Recipe {

    private String id;
    private String name;
    private int stars;

    //Uncomment to try livereload
//    private boolean fastFood;

    /**
     * Default constructor. Mandatory for json to java object.
     */
    public Recipe() {
    }

    public Recipe(String id, String name, int stars) {
        this.id = id;
        this.name = name;
        this.stars = stars;
    }

    /**
     * Sets new name.
     *
     * @param name New value of name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets name.
     *
     * @return Value of name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets new stars.
     *
     * @param stars New value of stars.
     */
    public void setStars(int stars) {
        this.stars = stars;
    }

    /**
     * Gets stars.
     *
     * @return Value of stars.
     */
    public int getStars() {
        return stars;
    }

    /**
     * Gets id.
     *
     * @return Value of id.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets new id.
     *
     * @param id New value of id.
     */
    public void setId(String id) {
        this.id = id;
    }

    //Uncomment to try livereload
//    /**
//     * Gets fastFood.
//     *
//     * @return Value of fastFood.
//     */
//    public boolean isFastFood() {
//        return fastFood;
//    }

    //Uncomment to try livereload
//    /**
//     * Sets new fastFood.
//     *
//     * @param fastFood New value of fastFood.
//     */
//    public void setFastFood(boolean fastFood) {
//        this.fastFood = fastFood;
//    }
}
