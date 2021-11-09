package kr.hs.emirim.sunw2311.hyojason_project;

public class MyReviewData {
    private String Name;
    private String Star;
    private String Info;

    public MyReviewData(String Name, String Info, String Star){
        this.Name = Name;
        this.Star = Star;
        this.Info = Info;
    }

    public String getR_Name() {
        return Name;
    }

    public String getR_Star() {
        return Star;
    }

    public String getR_Info() {
        return Info;
    }

}
