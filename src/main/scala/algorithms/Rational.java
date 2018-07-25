package algorithms;

public class Rational {
    private long _a; // numerator
    private long _b; // denominator

    public Rational(){
        _a=1; _b=1;
    }

    public Rational(long a, long b){
        // 约分
        long gcd = _gcd(a, b);
        _a = a/gcd;
        _b = b/gcd;
    }

    private static long _gcd(long x, long y){
        if(x<0) x = -x;
        if(y<0) y = -y;
        if(y==0) return x;
        return _gcd(y, x%y);
    }

    public Rational add(Rational x){
        return new Rational(this._a * x._b + this._b * x._a, this._b * x._b);
    }

    public Rational mul(Rational x){
        return new Rational(this._a * x._a, this._b * x._b);
    }

    public Rational negative(){
        return new Rational(-this._a, this._b);
    }

    public Rational sub(Rational x){
        return this.add(x.negative());
    }

    public Rational inverse(){
        return new Rational(this._b, this._a);
    }

    public Rational division(Rational x){
        return this.mul(x.inverse());
    }

    @Override
    public String toString() {
        return _a + " / " + _b;
    }
}
