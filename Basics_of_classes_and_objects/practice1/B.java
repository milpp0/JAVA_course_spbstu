package practice1;

class B extends A {
    @Override
    public void setX(int x) {
        this.x = x;
        this.y = x;
    }
    
    @Override
    public void setY(int y) {
        this.y = y;
        this.x = y;
    }
}