package in.project.Activelife.Exercise.model;

import java.util.ArrayList;

public class Exercise {
    private String Category;
    private String Difficulty;
    private String Force;
    private String Grips;
    private String details;
    private String exercise_name;
    private float id;
    ArrayList < Object > steps = new ArrayList < Object > ();
    Target TargetObject;
    ArrayList< Object > videoURL = new ArrayList < Object > ();
    private String youtubeURL;


    // Getter Methods

    public String getCategory() {
        return Category;
    }

    public String getDifficulty() {
        return Difficulty;
    }

    public String getForce() {
        return Force;
    }

    public String getGrips() {
        return Grips;
    }

    public String getDetails() {
        return details;
    }

    public String getExercise_name() {
        return exercise_name;
    }

    public float getId() {
        return id;
    }

    public Target getTarget() {
        return TargetObject;
    }

    public String getYoutubeURL() {
        return youtubeURL;
    }

    // Setter Methods

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public void setDifficulty(String Difficulty) {
        this.Difficulty = Difficulty;
    }

    public void setForce(String Force) {
        this.Force = Force;
    }

    public void setGrips(String Grips) {
        this.Grips = Grips;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setExercise_name(String exercise_name) {
        this.exercise_name = exercise_name;
    }

    public void setId(float id) {
        this.id = id;
    }

    public void setTarget(Target targetObject) {
        this.TargetObject = targetObject;
    }

    public void setYoutubeURL(String youtubeURL) {
        this.youtubeURL = youtubeURL;
    }
}
