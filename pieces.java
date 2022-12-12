class pieces{
    private int x;
    private int y;
    private String colour;
    private String state; 


    /**
     * Constructor for the pieces class
     * @param x row coordinate value (int)
     * @param y column coordinate value (int)
     * @param colour represents the colour of the piece. Either white or black
     * @param state represents the state of the piece. Either pawn or king
     */
    public pieces(int x, int y, String  colour, String state){
        this.x = x;
        this.y = y;
        this.colour = colour;
        this.state = state;
    }
    
    /**
     * Constructor that creates a piece with the same properties as another piece 
     * @param p represents the piece you want to copy
     */
    public pieces(pieces p){
        this.x = p.x;
        this.y = p.y;
        this.colour = p.colour;
        this.state = p.state;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     * To string method. The "b" represents the black pawn. The "B" represents the black king. 
     * The "w" represents the white pawn. The "W" represents the white king
     */
    public String toString(){
        if (this.colour == "black" && this.state == "pawn"){
            return "b";
        }
        else if (this.colour == "white" && this.state == "pawn"){
            return "w";
        }
        else if (this.colour == "black" && this.state == "king"){
            return "B";
        }
        else if (this.colour == "white" && this.state == "king"){
            return "W";
        }
        else{
            return " ";
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
}
