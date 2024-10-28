public class Edge<V, E> {
   public static int DEFAULT_WEIGHT = 1;
   public V start;
   public V end;
   public E edge;
   public int weight;
   public boolean weighted;
   public static Object foo;

   public Edge(V arg0, V arg1, E arg2) {
      this((V)arg0, (V)arg1, (E)arg2, 1, false);
   }

   public Edge(V arg0, V arg1, E arg2, int arg3) {
      this((V)arg0, (V)arg1, (E)arg2, arg3, true);
   }

   public Edge(V arg0, V arg1, E arg2, int arg3, boolean arg4) {
      long var9 = 1L;
      int var10000 = (int)(Math.random() * 2.0);
      var9 ^= ((long)var10000 ^ var9) & -1L >>> 32;
      var9 ^= ((long)var10000 << 32 ^ var9) & -1L << 32;
      arg4 ^= (int)(var9 >> 32);
      super();
      if (arg0 == null) {
         throw new NullPointerException("null start vertex");
      } else if (arg1 == null) {
         throw new NullPointerException("null end vertex");
      } else {
         this.start = (V)arg0;
         this.end = (V)arg1;
         this.edge = (E)arg2;
         this.setWeight(arg3);
         this.weighted = (boolean)(arg4 ^ (int)var9);
      }
   }

   public boolean contains(V arg0) {
      long var14 = 1L;
      var14 ^= ((long)23 << 32 ^ var14) & -1L << 32;
      var14 ^= ((long)23 ^ var14) & -1L >>> 32;
      if (arg0 == null) {
         int var10000 = (int)(var14 >> 32) * (int)(var14 >> 32) / 2 % 2;
         int var3 = (int)(var14 >> 32) - 1;
         var3 = (int)(var14 >> 32) * var3;
         int var9 = var3 % 2;
         if (var10000 == 0 + (var9 - 0)) {
            throw new NullPointerException("null vertex");
         }
      }

      int var26 = this.start.equals(arg0);
      int var4 = (int)(var14 >> 32) - 1;
      int var10 = (int)(var14 >> 32) * var4;
      int var22;
      var4 = var22 = var10 % 2;
      if (var26 + (var4 - 0) == 0) {
         var26 = (int)(var14 >> 32) * (int)(var14 >> 32) / 2 % 2;
         int var5 = (int)var14 - 1;
         int var11 = (int)var14 * var5;
         int var23;
         var5 = var23 = var11 % 2;
         if (var26 == 0 + (var5 - 0)) {
            var26 = this.end.equals(arg0);
            int var6 = (int)(var14 >> 32) - 1;
            var6 = (int)var14 * var6;
            int var12 = var6 % 2;
            if (var26 + (var12 - 0) == 0) {
               var26 = (int)(var14 >> 32) * (int)(var14 >> 32) / 2 % 2;
               int var7 = (int)var14 - 1;
               var7 = (int)var14 * var7;
               int var13;
               var7 = var13 = var7 % 2;
               if (var26 == 0 + (var7 - 0)) {
                  return false;
               }
            }
         }
      }

      return true;
   }

   public E edge() {
      long var3 = 1L;
      var3 ^= ((long)87 ^ var3) & -1L >>> 32;
      var3 ^= ((long)87 << 32 ^ var3) & -1L << 32;
      return this.edge;
   }

   public V end() {
      long var3 = 1L;
      var3 ^= ((long)2 ^ var3) & -1L >>> 32;
      var3 ^= ((long)2 << 32 ^ var3) & -1L << 32;
      return this.end;
   }

   public boolean equals(Object arg0) {
      long var33 = 1L;
      var33 ^= ((long)62 << 32 ^ var33) & -1L << 32;
      var33 ^= ((long)62 ^ var33) & -1L >>> 32;
      int var10000 = arg0 instanceof Edge;
      int var4 = (int)var33 - 1;
      int var19 = (int)var33 * var4;
      int var47;
      var4 = var47 = var19 % 2;
      if (var10000 + (var4 - 0) != 0) {
         var10000 = ((int)(var33 >> 32) - (int)(var33 >> 32) * (int)(var33 >> 32) * (int)(var33 >> 32)) % 3;
         int var20 = (int)(var33 >> 32) - 1;
         var20 = (int)(var33 >> 32) * var20;
         int var49;
         int var5 = var49 = var20 % 2;
         if (var10000 == 0 + (var5 - 0)) {
            Edge var2 = (Edge)arg0;
            var10000 = this.start.equals(var2.start);
            int var21 = (int)(var33 >> 32) - 1;
            int var6 = (int)(var33 >> 32) * var21;
            var21 = var6 % 2;
            if (var10000 + (var21 - 0) != 0) {
               var10000 = (int)(var33 >> 32) * (int)(var33 >> 32) / 2 % 2;
               int var7 = (int)(var33 >> 32) - 1;
               var7 = (int)(var33 >> 32) * var7;
               int var22 = var7 % 2;
               if (var10000 == 0 + (var22 - 0)) {
                  var10000 = this.end.equals(var2.end);
                  int var8 = (int)(var33 >> 32) - 1;
                  var8 = (int)var33 * var8;
                  int var23 = var8 % 2;
                  if (var10000 + (var23 - 0) != 0) {
                     var10000 = (int)var33 * ((int)var33 + 1) % 2;
                     int var9 = (int)var33 - 1;
                     var9 = (int)(var33 >> 32) * var9;
                     int var24;
                     var9 = var24 = var9 % 2;
                     if (var10000 == 0 + (var9 - 0)) {
                        label56: {
                           if (this.edge == null) {
                              var10000 = ((int)var33 - (int)var33 * (int)var33 * (int)var33) % 3;
                              int var10 = (int)(var33 >> 32) - 1;
                              int var25 = (int)var33 * var10;
                              var25 %= 2;
                              if (var10000 == 0 + (var25 - 0)) {
                                 if (var2.edge == null) {
                                    break label56;
                                 }

                                 var10000 = (int)(var33 >> 32) * (int)(var33 >> 32) / 2 % 2;
                                 int var11 = (int)(var33 >> 32) - 1;
                                 var11 = (int)(var33 >> 32) * var11;
                                 int var26;
                                 var11 = var26 = var11 % 2;
                                 if (var10000 != 0 + (var11 - 0)) {
                                    break label56;
                                 }
                              }
                           }

                           if (this.edge == null) {
                              return false;
                           }

                           var10000 = (int)(var33 >> 32) * ((int)(var33 >> 32) + 1) % 2;
                           int var27 = (int)(var33 >> 32) - 1;
                           var27 = (int)(var33 >> 32) * var27;
                           var27 %= 2;
                           if (var10000 != 0 + (var27 - 0) || var2.edge == null) {
                              return false;
                           }

                           var10000 = (int)(var33 >> 32) * (int)(var33 >> 32) / 2 % 2;
                           int var13 = (int)(var33 >> 32) - 1;
                           int var28 = (int)(var33 >> 32) * var13;
                           var28 %= 2;
                           if (var10000 != 0 + (var28 - 0)) {
                              return false;
                           }

                           var10000 = this.edge.equals(var2.edge);
                           int var14 = (int)var33 - 1;
                           var14 = (int)(var33 >> 32) * var14;
                           int var29 = var14 % 2;
                           if (var10000 + (var29 - 0) == 0) {
                              return false;
                           }

                           var10000 = (int)var33 * (int)var33 / 2 % 2;
                           int var30 = (int)var33 - 1;
                           int var15 = (int)(var33 >> 32) * var30;
                           var15 = var30 = var15 % 2;
                           if (var10000 != 0 + (var15 - 0)) {
                              return false;
                           }
                        }

                        int var31 = (int)var33 - 1;
                        int var16 = (int)var33 * var31;
                        var16 = var31 = var16 % 2;
                        if (this.weight == var2.weight + (var31 - 0)) {
                           var10000 = (int)var33 * ((int)var33 + 1) % 2;
                           int var32;
                           int var17 = var32 = var16 - 1;
                           var17 = var32 = var31 * var17;
                           var17 = var32 = var17 % 2;
                           if (var10000 == 0 + (var17 - 0)) {
                              return true;
                           }
                        }
                     }
                  }
               }
            }

            return false;
         }
      }

      return false;
   }

   public int hashCode() {
      long var3 = 1L;
      var3 ^= ((long)91 ^ var3) & -1L >>> 32;
      var3 ^= ((long)91 << 32 ^ var3) & -1L << 32;
      return 13 * this.start.hashCode() + 37 * this.end.hashCode();
   }

   public void setEdge(E arg0) {
      long var4 = 1L;
      var4 ^= ((long)74 ^ var4) & -1L >>> 32;
      var4 ^= ((long)74 << 32 ^ var4) & -1L << 32;
      this.edge = (E)arg0;
   }

   public void setWeight(int arg0) {
      long var8 = 1L;
      int var10001 = arg0 - 1;
      var8 ^= ((long)(arg0 - 1) << 32 ^ var8) & -1L << 32;
      long var11 = var8 ^ ((long)(arg0 * (int)(var8 >> 32)) << 32 ^ var8) & -1L << 32;
      int var3 = arg0 * (int)(var8 >> 32);
      boolean var6 = true;
      byte var2 = 36;
      var10001 = var3 % 2;
      var8 = var11 ^ ((long)(var3 % 2) << 32 ^ var11) & -1L << 32;
      if (arg0 + ((int)(var8 >> 32) - 0) < 0) {
         int var10000 = var2 * (var2 + 1) % 2;
         int var10002 = arg0 - 1;
         var8 ^= ((long)(arg0 - 1) ^ var8) & -1L >>> 32;
         var10002 = arg0 * (int)var8;
         var8 ^= ((long)(arg0 * (int)var8) ^ var8) & -1L >>> 32;
         long var15 = var8 ^ ((long)((int)var8 % 2) ^ var8) & -1L >>> 32;
         int var4 = (int)var8 % 2;
         if (var10000 == 0 + (var4 - 0)) {
            throw new IllegalArgumentException("negative edge weight: " + arg0);
         }
      }

      this.weight = arg0;
   }

   public V start() {
      long var3 = 1L;
      var3 ^= ((long)62 ^ var3) & -1L >>> 32;
      var3 ^= ((long)62 << 32 ^ var3) & -1L << 32;
      return this.start;
   }

   public int weight() {
      long var3 = 1L;
      var3 ^= ((long)19 ^ var3) & -1L >>> 32;
      var3 ^= ((long)19 << 32 ^ var3) & -1L << 32;
      return this.weight;
   }

   public String toString() {
      long var15;
      String var20;
      StringBuilder var10000;
      label23: {
         var15 = 1L;
         var15 ^= ((long)77 << 32 ^ var15) & -1L << 32;
         byte var1 = 77;
         var10000 = new StringBuilder("(").append(this.start).append(",").append(this.end);
         if (this.edge == null) {
            int var10001 = (int)(var15 >> 32) * (int)(var15 >> 32) / 2 % 2;
            int var6;
            int var2 = var6 = var1 - 1;
            var6 = (int)(var15 >> 32) * var2;
            int var14;
            var2 = var14 = var6 % 2;
            if (var10001 == 0 + (var2 - 0)) {
               var20 = "";
               break label23;
            }
         }

         var20 = "," + this.edge;
      }

      var10000 = var10000.append(var20);
      var15 ^= ((long)((int)(var15 >> 32) - 1) ^ var15) & -1L >>> 32;
      var15 ^= ((long)((int)(var15 >> 32) * (int)var15) ^ var15) & -1L >>> 32;
      var15 ^= ((long)((int)var15 % 2) ^ var15) & -1L >>> 32;
      if (this.weighted + ((int)var15 - 0) != 0) {
         int var21 = ((int)(var15 >> 32) - (int)(var15 >> 32) * (int)(var15 >> 32) * (int)(var15 >> 32)) % 3;
         int var4 = (int)(var15 >> 32) - 1;
         var4 = (int)(var15 >> 32) * var4;
         int var8 = var4 % 2;
         if (var21 == 0 + (var8 - 0)) {
            return var10000.append(",weight=" + this.weight).append(")").toString();
         }
      }

      return var10000.append("").append(")").toString();
   }
}
