package lessonseven;


public class CarMake implements Comparable<CarMake> {
    private String make;
    private int skorost;
    private int rashod;
    private int bak;

    public CarMake(String make, int skorost, int rashod, int bak) {
        this.make = make;
        this.skorost = skorost;
        this.rashod = rashod;
        this.bak = bak;
    }
    public CarMake() {

    }

        public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getSkorost() {
        return skorost;
    }

    public void setSkorost() {
        this.skorost = skorost;
    }

    public int getRashod() {
        return rashod;
    }

    public void setRashod() {
        this.rashod = rashod;
    }

    public int getBak() {
        return bak;
    }

    public void setBak() {
        this.bak = bak;
    }

    /*
     * Added task number three. Have to use comparable interface.
     */
    @Override
    public int compareTo(CarMake o) {
        return this.getMake().compareTo(o.getMake());
    }

    public String toString() {
        return "make=" + make + ", skorost=" + skorost + ", rashod=" + rashod + ", bak=" + bak;
    }


}

