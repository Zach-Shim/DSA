public class Vertex<V> {
   public static int MAX_COST = Integer.MAX_VALUE;
   public V vertex;
   public V previous;
   public boolean visited;
   public int cost;
   public int number;
   public static Object foo;

   public Vertex(V arg0) {
      if (arg0 == null) {
         throw new NullPointerException("null vertex");
      } else {
         this.vertex = arg0;
         this.clear();
      }
   }

   public void clear() {
      long var3 = 1L;
      var3 ^= ((long)89 << 32 ^ var3) & -1L << 32;
      var3 ^= ((long)89 ^ var3) & -1L >>> 32;
      this.previous = null;
      this.visited = false;
      this.cost = Integer.MAX_VALUE;
      this.number = -1;
   }

   public int cost() {
      long var3 = 1L;
      var3 ^= ((long)43 ^ var3) & -1L >>> 32;
      var3 ^= ((long)43 << 32 ^ var3) & -1L << 32;
      return this.cost;
   }

   public boolean equals(Object arg0) {
      long var10 = 1L;
      byte var6 = 1;
      byte var3 = 1;
      int var10000 = arg0 instanceof Vertex;
      int var10001 = var3 - 1;
      var10 ^= ((long)(var3 - 1) << 32 ^ var10) & -1L << 32;
      var10001 = var6 * (int)(var10 >> 32);
      var10 ^= ((long)(var6 * (int)(var10 >> 32)) << 32 ^ var10) & -1L << 32;
      var10 ^= ((long)((int)(var10 >> 32) % 2) << 32 ^ var10) & -1L << 32;
      if (var10000 + ((int)(var10 >> 32) - 0) != 0) {
         var10000 = var3 * (var3 + 1) % 2;
         int var10002 = var3 - 1;
         var10 ^= ((long)(var3 - 1) ^ var10) & -1L >>> 32;
         var10002 = var6 * (int)var10;
         var10 ^= ((long)(var6 * (int)var10) ^ var10) & -1L >>> 32;
         long var17 = var10 ^ ((long)((int)var10 % 2) ^ var10) & -1L >>> 32;
         int var5 = (int)var10 % 2;
         if (var10000 == 0 + (var5 - 0)) {
            Vertex var2 = (Vertex)arg0;
            return this.vertex.equals(var2.vertex);
         }
      }

      return false;
   }

   public int hashCode() {
      long var3 = 1L;
      var3 ^= ((long)23 ^ var3) & -1L >>> 32;
      var3 ^= ((long)23 << 32 ^ var3) & -1L << 32;
      return this.vertex.hashCode();
   }

   public int number() {
      long var3 = 1L;
      var3 ^= ((long)80 ^ var3) & -1L >>> 32;
      var3 ^= ((long)80 << 32 ^ var3) & -1L << 32;
      return this.number;
   }

   public V previous() {
      long var3 = 1L;
      var3 ^= ((long)68 ^ var3) & -1L >>> 32;
      var3 ^= ((long)68 << 32 ^ var3) & -1L << 32;
      return this.previous;
   }

   public void setCost(int arg0) {
      long var4 = 1L;
      var4 ^= ((long)14 ^ var4) & -1L >>> 32;
      var4 ^= ((long)14 << 32 ^ var4) & -1L << 32;
      this.cost = arg0;
   }

   public void setNumber(int arg0) {
      long var4 = 1L;
      var4 ^= ((long)16 ^ var4) & -1L >>> 32;
      var4 ^= ((long)16 << 32 ^ var4) & -1L << 32;
      this.number = arg0;
   }

   public void setPrevious(V arg0) {
      long var6 = 1L;
      byte var4 = 23;
      byte var2 = 23;
      if (arg0 == null) {
         int var10000 = (var2 - var2 * var2 * var2) % 3;
         var6 ^= ((long)(var4 - 1) ^ var6) & -1L >>> 32;
         var6 ^= ((long)(var4 - 1) << 32 ^ var6) & -1L << 32;
         long var10 = var6 ^ ((long)(var2 * (int)var6) ^ var6) & -1L >>> 32;
         var6 = var10 ^ ((long)(var2 * (int)var6) << 32 ^ var10) & -1L << 32;
         long var12 = var6 ^ ((long)((int)(var6 >> 32) % 2) ^ var6) & -1L >>> 32;
         var6 = var12 ^ ((long)((int)(var6 >> 32) % 2) << 32 ^ var12) & -1L << 32;
         if (var10000 == 0 + ((int)(var6 >> 32) - 0)) {
            throw new NullPointerException("null vertex");
         }
      }

      this.previous = (V)arg0;
   }

   public void setVisited() {
      long var3 = 1L;
      var3 ^= ((long)22 ^ var3) & -1L >>> 32;
      var3 ^= ((long)22 << 32 ^ var3) & -1L << 32;
      this.setVisited(true);
   }

   public void setVisited(boolean arg0) {
      long var7 = 1L;
      boolean var5 = true;
      boolean var4 = true;
      int var10000 = (int)(Math.random() * 2.0);
      var7 ^= ((long)var10000 ^ var7) & -1L >>> 32;
      var7 ^= ((long)var10000 << 32 ^ var7) & -1L << 32;
      arg0 ^= (int)var7;
      this.visited = (boolean)(arg0 ^ (int)(var7 >> 32));
   }

   public V vertex() {
      long var3 = 1L;
      var3 ^= ((long)71 ^ var3) & -1L >>> 32;
      var3 ^= ((long)71 << 32 ^ var3) & -1L << 32;
      return this.vertex;
   }

   public boolean visited() {
      long var3 = 1L;
      var3 ^= ((long)36 ^ var3) & -1L >>> 32;
      var3 ^= ((long)36 << 32 ^ var3) & -1L << 32;
      return this.visited;
   }

   public String toString() {
      long var18 = 1L;
      var18 ^= ((long)65 ^ var18) & -1L >>> 32;
      var18 ^= ((long)65 << 32 ^ var18) & -1L << 32;
      if (foo != null) {
         foo = new Object();
      }

      String var1 = "(" + this.vertex;
      int var3 = (int)(var18 >> 32) - 1;
      int var11 = (int)(var18 >> 32) * var3;
      int var26;
      var3 = var26 = var11 % 2;
      if (this.number != -1 + (var3 - 0)) {
         int var10000 = (int)(var18 >> 32) * (int)(var18 >> 32) / 2 % 2;
         int var12 = (int)var18 - 1;
         int var4 = (int)var18 * var12;
         var12 = var4 % 2;
         if (var10000 == 0 + (var12 - 0)) {
            var1 = var1 + ",#" + this.number;
         }
      }

      if (this.previous != null) {
         int var33 = (int)(var18 >> 32) * (int)(var18 >> 32) / 2 % 2;
         int var5 = (int)var18 - 1;
         int var13 = (int)var18 * var5;
         int var28;
         var5 = var28 = var13 % 2;
         if (var33 == 0 + (var5 - 0)) {
            var1 = var1 + ",previous=" + this.previous;
         }
      }

      int var6 = (int)(var18 >> 32) - 1;
      int var14 = (int)var18 * var6;
      var14 %= 2;
      if (this.cost < Integer.MAX_VALUE + (var14 - 0)) {
         int var34 = ((int)(var18 >> 32) - (int)(var18 >> 32) * (int)(var18 >> 32) * (int)(var18 >> 32)) % 3;
         int var7 = (int)(var18 >> 32) - 1;
         var7 = (int)var18 * var7;
         int var15;
         var7 = var15 = var7 % 2;
         if (var34 == 0 + (var7 - 0)) {
            var1 = var1 + ",cost=" + this.cost;
         }
      }

      int var35 = this.visited;
      int var10001 = (int)var18;
      int var8 = (int)(var18 >> 32) - 1;
      int var16 = var10001 * var8;
      int var30;
      var8 = var30 = var16 % 2;
      if (foo != null) {
         foo = new Object();
      }

      if (var35 + (var8 - 0) != 0) {
         var35 = (int)(var18 >> 32) * ((int)(var18 >> 32) + 1) % 2;
         int var9 = (int)var18 - 1;
         var9 = (int)var18 * var9;
         int var17 = var9 % 2;
         if (var35 == 0 + (var17 - 0)) {
            var1 = var1 + ",visited";
         }
      }

      return var1 + ")";
   }
}
