class Solution {
    int doOverlap(int l1[], int r1[], int l2[], int r2[]) {
        // code here
        /*
         * if x-co-ordinates or y-co-ordinate
         * of diagonal points i.e l1,r1 or l2,r2 then rectange
         * formation is not possible
         */
        if (l1[0] == r1[0] || l1[1] == r1[1] || l2[0] == r2[0] || l2[1] == r2[1]) {

            return 0;
        }

        // If one rectangle is on left side of other
        if (l1[0] >= r2[0] || l2[0] >= r1[0]) {
            return 0;
        }

        // If one rectangle is above other
        if (r1[1] >= l2[1] || r2[1] >= l1[1]) {
            return 0;
        }

        return 1;
    }

};