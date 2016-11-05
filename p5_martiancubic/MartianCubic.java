package p5_martiancubic;

import p5_utility.DoubleWithAppx;

/**
 * A general representation of a Martian Cubic of the form:
 *     (a*x^3 + b*x^2 + c*x + d)
 * 
 * @author Evan Golub
 * @date August-October 2016
 */

public class MartianCubic {    
	private final DoubleWithAppx a;
	private final DoubleWithAppx b;
	private final DoubleWithAppx c;
	private final DoubleWithAppx d;
	
	public MartianCubic() {
	this.a= new DoubleWithAppx(0);
	this.b= new DoubleWithAppx(0);
	this.c= new DoubleWithAppx(0);
	this.d= new DoubleWithAppx(0);
		
	}

	public MartianCubic(DoubleWithAppx dIn) {
	this.a=new DoubleWithAppx(0);
	this.b=new DoubleWithAppx(0);
	this.c=new DoubleWithAppx(0);
	this.d= new DoubleWithAppx(dIn);
	}

	public MartianCubic(DoubleWithAppx cIn, DoubleWithAppx dIn) {
	this.a= new DoubleWithAppx(0);
	this.b= new DoubleWithAppx(0);
	this.c= new DoubleWithAppx(cIn);
	this.d= new DoubleWithAppx(dIn);
	}

	public MartianCubic(DoubleWithAppx bIn, DoubleWithAppx cIn, DoubleWithAppx dIn) {
		this.a= new DoubleWithAppx(0);
		this.b= new DoubleWithAppx(bIn);
		this.c= new DoubleWithAppx(cIn);
		this.d= new DoubleWithAppx(dIn);
	}
	
	public MartianCubic(DoubleWithAppx aIn, DoubleWithAppx bIn, DoubleWithAppx cIn, DoubleWithAppx dIn) {
		this.a= new DoubleWithAppx(aIn);
		this.b= new DoubleWithAppx(bIn);
		this.c= new DoubleWithAppx(cIn);
		this.d= new DoubleWithAppx(dIn);
	}
	
	public MartianCubic(MartianCubic other) {
		this.a= other.getA();
		this.b= other.getB();
		this.c= other.getC();
		this.d= other.getD();
		
	}
	
	public DoubleWithAppx getA() {
		return this.a;
	}
	
	public DoubleWithAppx getB() {
		return this.b;
	}
	
	public DoubleWithAppx getC() {
		return this.c;
	}
	
	public DoubleWithAppx getD() {
		return this.d;
	}
	
	
	
	
	/*this method takes one parameter (DoubleWithAppx), evaluates the Martian
	 *cubic at the point represented by the parameter and returns a DoubleWithAppx
	 *representing the result of that evaluation.  (i.e., if your Martian cubic
	 *is 5x^3-3x^2+2x+4, and you call eval(5), it should return 564.)*/
	public DoubleWithAppx eval(DoubleWithAppx x) {
		DoubleWithAppx partA = x.power(3).multiply(a);
		DoubleWithAppx partB = x.power(2).multiply(b);
		DoubleWithAppx partC = x.multiply(c);
		DoubleWithAppx result = partA.add(partB).add(partC).add(d);
		return result;
		//return a.multiply(x.power(3)).add(b.multiply(x.power(2)).add(c.multiply(x)).add(d));
	
		//HINT: Think about how to chain method calls to make this compact. 
	
	}
	
	
	public MartianCubic add(MartianCubic martianCubicIn) {
		DoubleWithAppx newA=this.a.add(martianCubicIn.getA());
		DoubleWithAppx newB=this.b.add(martianCubicIn.getB());
		DoubleWithAppx newC=this.c.add(martianCubicIn.getC());
		DoubleWithAppx newD=this.d.add(martianCubicIn.getD());
		return new MartianCubic(newA, newB, newC,newD);
	}

	public MartianCubic subtract(MartianCubic martianCubicIn) {
		DoubleWithAppx newA=this.a.subtract(martianCubicIn.getA());
		DoubleWithAppx newB=this.b.subtract(martianCubicIn.getB());
		DoubleWithAppx newC=this.c.subtract(martianCubicIn.getC());
		DoubleWithAppx newD=this.d.subtract(martianCubicIn.getD());
		return new MartianCubic(newA, newB, newC,newD);
	}



	public MartianCubic glorp(MartianCubic martianCubicIn) {
		DoubleWithAppx tempOne=((this.getA().multiply(martianCubicIn.getB())).add(this.b.multiply(martianCubicIn.getA())));
		
		if(tempOne.compareTo(DoubleWithAppx.ZERO)==0){
		DoubleWithAppx tempA = this.a.multiply(martianCubicIn.getA());
		DoubleWithAppx tempB = ((this.c.multiply(martianCubicIn.getB())).add(this.b.multiply(martianCubicIn.getA())).add(this.a.multiply(this.d)));
		DoubleWithAppx tempC = (this.c.multiply(martianCubicIn.getA())).add(this.b.multiply(this.d));
		DoubleWithAppx tempD = (this.c.multiply(this.d)).multiply(martianCubicIn.getC().multiply(martianCubicIn.getD()));
		
		return new MartianCubic(tempA,tempB,tempC,tempD);
		}		
		else{
			return null;
		}
	}
	
	
	
	
	public MartianCubic splee() {
		DoubleWithAppx tempA= new DoubleWithAppx(18);
		DoubleWithAppx tempB= new DoubleWithAppx((this.a.multiply(this.b).multiply(this.c).multiply(this.d)));
		DoubleWithAppx tempC= new DoubleWithAppx(-4);
		DoubleWithAppx tempD= new DoubleWithAppx(this.d.multiply((this.b.power(3))));
		return new MartianCubic(tempA.multiply(tempB),DoubleWithAppx.ZERO,tempC.multiply(tempD),DoubleWithAppx.ZERO);

		//ax^3 + bx^2 + cx + d" is "18abcdx^3 - 4b^3dx"
	}

	
	
	public DoubleWithAppx cliff() {

DoubleWithAppx tempA= new DoubleWithAppx(this.a.power(3));
DoubleWithAppx tempB= new DoubleWithAppx(this.b.power(3));
DoubleWithAppx tempC= new DoubleWithAppx(this.c.power(3));
DoubleWithAppx tempD= new DoubleWithAppx(this.d.power(3));
	(tempA.add(tempB.add(tempC.add(tempD)))).realroot(4);
	if (tempA.add(tempB.add(tempC.add(tempD))).compareTo(new DoubleWithAppx (0)) >=0) {
		return (tempA.add(tempB.add(tempC.add(tempD)))).realroot(4);
	}
	else{
		return new  DoubleWithAppx(42);
	}
	}


	
	public int compareTo(MartianCubic martianPolyIn) {
		return this.cliff().compareTo(martianPolyIn.cliff());
		
	}

	
	
	
    public String toString() { 
		throw new RuntimeException("You need to implement this!");
} 
	

	
	
	
	
	
	//NOTE: THIS IS WRITTEN FOR YOU - DO NOT CHANGE
	@Override
	public boolean equals (Object other) {
		if (other == null) {
			return false;
		}
		else if (this.getClass()!=other.getClass()) {
			return false;
		}
		else {
			MartianCubic casted = (MartianCubic)other;
			return (
					a.equals(casted.a) && 
					b.equals(casted.b) && 
					c.equals(casted.c) && 
					d.equals(casted.d)
			);
		}
	}
	
	
}