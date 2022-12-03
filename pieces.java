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
        if (this.colour == "black"){
            return "b";
        }
        else if (this.colour == "white"){
            return "w";
        }
        else{
            return " ";
        }
    }
    
}