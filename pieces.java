class pieces{
    int x;
    int y;
    String colour;
    String state; 

    public pieces(int x, int y, String  colour, String state){
        this.x = x;
        this.y = y;
        this.colour = colour;
        this.state = state;
    }
    
    public pieces(pieces p){
        this.x = p.x;
        this.y = p.y;
        this.colour = p.colour;
        this.state = p.state;
    }

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
    
}
