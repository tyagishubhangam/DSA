/*Complete the function below*/
class GfG {
    int find(int par[], int x) {
        // add code here.
        if(par[x] == x){
            return x;
        }
        return find(par, par[x]);
    }

    void unionSet(int par[], int x, int z) {
        // add code here.
        int parx = find(par, x);
        int pary = find(par, z);
        if(parx != pary){
            par[parx] = pary;
        }
    }
}