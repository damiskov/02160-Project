package view;

//Used as pair of sprites and inner+outer colour
public class ChainPair<L,R,C1,C2> {
	    private L l;
	    private R r;
	    private C1 c1;
	    private C2 c2;
	    public ChainPair(L l, R r, C1 c1, C2 c2){
	        this.l = l;
	        this.r = r;
	        this.c1 = c1;
	        this.c2 = c2;
	    }
	    public L getL(){ return l; }
	    public R getR(){ return r; }
	    public C1 getC1(){ return c1; }
	    public C2 getC2(){ return c2; }
	    public void setL(L l){ this.l = l; }
	    public void setR(R r){ this.r = r; }
	    public void setC1(C1 c1){ this.c1 = c1; }
	    public void setC2(C2 c2){ this.c2 = c2; }
	    
	}
