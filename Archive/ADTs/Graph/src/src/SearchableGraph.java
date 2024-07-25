import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class SearchableGraph<V, E> extends AbstractGraph<V, E> {
   public static Object foo;

   public static <V, E> SearchableGraph<V, E> create() {
      long var2 = 1L;
      var2 ^= ((long)5 ^ var2) & -1L >>> 32;
      var2 ^= ((long)5 << 32 ^ var2) & -1L << 32;
      return create(false, false);
   }

   public static <V, E> SearchableGraph<V, E> create(boolean arg0) {
      long var6 = 1L;
      boolean var4 = true;
      var6 ^= ((long)58 ^ var6) & -1L >>> 32;
      var6 ^= ((long)((int)(Math.random() * 2.0)) << 32 ^ var6) & -1L << 32;
      arg0 ^= (int)(var6 >> 32);
      return create((boolean)(arg0 ^ (int)(var6 >> 32)), false);
   }

   public static <V, E> SearchableGraph<V, E> create(boolean arg0, boolean arg1) {
      long var10 = 1L;
      boolean var6 = true;
      boolean var5 = true;
      var10 ^= ((long)((int)(Math.random() * 2.0)) << 32 ^ var10) & -1L << 32;
      arg1 ^= (int)(var10 >> 32);
      var10 ^= ((long)((int)(Math.random() * 2.0)) ^ var10) & -1L >>> 32;
      arg0 ^= (int)var10;
      return new SearchableGraph<>((boolean)(arg0 ^ (int)var10), (boolean)(arg1 ^ (int)(var10 >> 32)));
   }

   public SearchableGraph() {
   }

   public SearchableGraph(boolean arg0, boolean arg1) {
      long var8 = 1L;
      int var6;
      var8 ^= ((long)(var6 = (int)(Math.random() * 2.0)) ^ var8) & -1L >>> 32;
      arg1 ^= var6;
      var8 ^= ((long)((int)(Math.random() * 2.0)) << 32 ^ var8) & -1L << 32;
      arg0 ^= (int)(var8 >> 32);
      super((boolean)(arg0 ^ (int)(var8 >> 32)), (boolean)(arg1 ^ (int)var8));
   }

   @Override
   public boolean isReachable(V arg0, V arg1) {
      long var5 = 1L;
      var5 ^= ((long)17 ^ var5) & -1L >>> 32;
      var5 ^= ((long)17 << 32 ^ var5) & -1L << 32;
      this.checkVertices((V)arg0, (V)arg1);
      this.clearVertexInfo();
      return this.isReachableHelper$((V)arg0, (V)arg1);
   }

   public boolean isReachableHelper$(V arg0, V arg1) {
      long var24 = 1L;
      var24 ^= ((long)51 << 32 ^ var24) & -1L << 32;
      var24 ^= ((long)51 ^ var24) & -1L >>> 32;
      int var10000 = arg0.equals(arg1);
      int var15 = (int)(var24 >> 32) - 1;
      int var6 = (int)(var24 >> 32) * var15;
      var15 = var6 % 2;
      if (var10000 + (var15 - 0) != 0) {
         var10000 = (int)var24 * (int)var24 / 2 % 2;
         int var7 = (int)var24 - 1;
         int var16 = (int)(var24 >> 32) * var7;
         int var31;
         var7 = var31 = var16 % 2;
         if (var10000 == 0 + (var7 - 0)) {
            return true;
         }
      }

      this.vertexInfo((V)arg0).setVisited();
      Iterator var4 = this.neighbors((V)arg0).iterator();

      while(true) {
         var10000 = var4.hasNext();
         int var12 = (int)(var24 >> 32) - 1;
         int var21 = (int)var24 * var12;
         int var37;
         var12 = var37 = var21 % 2;
         if (var10000 + (var12 - 0) == 0) {
            var10000 = (int)(var24 >> 32) * (int)(var24 >> 32) / 2 % 2;
            int var22 = (int)(var24 >> 32) - 1;
            int var13 = (int)var24 * var22;
            var13 = var22 = var13 % 2;
            if (var10000 == 0 + (var13 - 0)) {
               if (foo != null) {
                  foo = new Object();
               }

               return false;
            }
         }

         Object var3 = var4.next();
         var10000 = this.vertexInfo((V)var3).visited();
         int var17 = (int)(var24 >> 32) - 1;
         int var8 = (int)var24 * var17;
         var8 = var17 = var8 % 2;
         if (var10000 + (var8 - 0) == 0) {
            var10000 = (int)(var24 >> 32) * ((int)(var24 >> 32) + 1) % 2;
            int var18 = (int)var24 - 1;
            var18 = (int)var24 * var18;
            int var34;
            int var9 = var34 = var18 % 2;
            if (var10000 == 0 + (var9 - 0)) {
               var10000 = this.isReachableHelper$((V)var3, (V)arg1);
               int var10001 = (int)(var24 >> 32);
               int var19 = (int)(var24 >> 32) - 1;
               if (foo != null) {
                  foo = new Object();
               }

               int var10 = var10001 * var19;
               var19 = var10 % 2;
               if (var10000 + (var19 - 0) != 0) {
                  var10000 = ((int)var24 - (int)var24 * (int)var24 * (int)var24) % 3;
                  int var11 = (int)(var24 >> 32) - 1;
                  int var20 = (int)var24 * var11;
                  var20 %= 2;
                  if (var10000 == 0 + (var20 - 0)) {
                     return true;
                  }
               }
            }
         }
      }
   }

   @Override
   public List<V> minimumWeightPath(V arg0, V arg1) {
      long var39 = 1L;
      var39 ^= ((long)72 ^ var39) & -1L >>> 32;
      var39 ^= ((long)72 << 32 ^ var39) & -1L << 32;
      this.checkVertices((V)arg0, (V)arg1);
      this.clearVertexInfo();
      this.vertexInfo((V)arg0).setCost(0);
      Set var3 = this.vertices();
      PriorityQueue var4 = new PriorityQueue(var3.size() + 10, new SearchableGraph.VertexCostComparator(null));
      var4.addAll(var3);

      while(true) {
         int var10000 = var4.isEmpty();
         int var34 = (int)(var39 >> 32) - 1;
         var34 = (int)var39 * var34;
         int var61;
         int var20 = var61 = var34 % 2;
         if (var10000 + (var20 - 0) != 0) {
            var10000 = (int)var39 * (int)var39 / 2 % 2;
            int var35;
            int var21 = var35 = var61 - 1;
            var35 = var61 * var21;
            int var63;
            var21 = var63 = var35 % 2;
            if (var10000 == 0 + (var21 - 0)) {
               var10000 = Math.abs(this.vertexInfo((V)arg1).cost());
               int var36 = var21 - 1;
               var36 = var21 * var36;
               var36 %= 2;
               if (var10000 >= Integer.MAX_VALUE + (var36 - 0)) {
                  var10000 = ((int)(var39 >> 32) - (int)(var39 >> 32) * (int)(var39 >> 32) * (int)(var39 >> 32)) % 3;
                  int var37;
                  int var23 = var37 = var63 - 1;
                  var37 = var21 * var23;
                  int var67;
                  var23 = var67 = var37 % 2;
                  if (var10000 == 0 + (var23 - 0)) {
                     return null;
                  }
               }

               return this.reconstructPath$((V)arg0, (V)arg1);
            }
         }

         Object var5 = var4.remove();
         Vertex var6 = this.vertexInfo((V)var5);
         var6.setVisited();
         var10000 = var6.cost();
         int var12 = (int)var39 - 1;
         var12 = (int)var39 * var12;
         int var25 = var12 % 2;
         if (var10000 == Integer.MAX_VALUE + (var25 - 0)) {
            var10000 = (int)(var39 >> 32) * (int)(var39 >> 32) / 2 % 2;
            int var13 = (int)(var39 >> 32) - 1;
            int var26 = (int)(var39 >> 32) * var13;
            int var50;
            var13 = var50 = var26 % 2;
            if (var10000 == 0 + (var13 - 0)) {
               var4.clear();
               continue;
            }
         }

         Iterator var8 = this.neighbors((V)var5).iterator();

         while(true) {
            var10000 = var8.hasNext();
            int var18 = (int)(var39 >> 32) - 1;
            int var32 = (int)(var39 >> 32) * var18;
            int var57;
            var18 = var57 = var32 % 2;
            if (var10000 + (var18 - 0) == 0) {
               var10000 = ((int)var39 - (int)var39 * (int)var39 * (int)var39) % 3;
               int var33;
               int var19 = var33 = var57 - 1;
               var19 = var33 = var18 * var19;
               var19 = var33 = var19 % 2;
               int var10001 = 0 + (var19 - 0);
               if (foo != null) {
                  foo = new Object();
               }

               if (var10000 == var10001) {
                  break;
               }
            }

            Object var7 = var8.next();
            Vertex var9 = this.vertexInfo((V)var7);
            var10000 = var9.visited();
            int var14 = (int)var39 - 1;
            int var27 = (int)var39 * var14;
            var27 %= 2;
            if (var10000 + (var27 - 0) == 0) {
               var10000 = (int)(var39 >> 32) * (int)(var39 >> 32) / 2 % 2;
               int var28 = (int)var39 - 1;
               int var15 = (int)(var39 >> 32) * var28;
               var15 = var28 = var15 % 2;
               if (var10000 == 0 + (var15 - 0)) {
                  int var29;
                  int var10 = var29 = var6.cost() + this.edgeWeight((V)var5, (V)var7);
                  int var80 = var9.cost();
                  int var30 = var29 - 1;
                  int var53;
                  int var16 = var53 = var10 * var30;
                  var16 = var30 = var16 % 2;
                  if (var10 < var80 + (var16 - 0)) {
                     var10000 = (int)(var39 >> 32) * (int)(var39 >> 32) / 2 % 2;
                     int var31 = var16 - 1;
                     var31 = var30 * var31;
                     int var56;
                     int var17 = var56 = var31 % 2;
                     if (var10000 == 0 + (var17 - 0)) {
                        var4.remove(var7);
                        var9.setCost(var29);
                        var9.setPrevious(var5);
                        var4.add(var7);
                     }
                  }
               }
            }
         }
      }
   }

   @Override
   public List<V> shortestPath(V arg0, V arg1) {
      long var27 = 1L;
      var27 ^= ((long)35 ^ var27) & -1L >>> 32;
      var27 ^= ((long)35 << 32 ^ var27) & -1L << 32;
      this.checkVertices((V)arg0, (V)arg1);
      this.clearVertexInfo();
      List var3 = null;
      LinkedList var4 = new LinkedList();
      var4.add(arg0);
      this.vertexInfo((V)arg0).setVisited();

      while(true) {
         int var10000 = var4.isEmpty();
         int var25 = (int)(var27 >> 32) - 1;
         int var16 = (int)var27 * var25;
         var25 = var16 % 2;
         if (var10000 + (var25 - 0) != 0) {
            var10000 = ((int)(var27 >> 32) - (int)(var27 >> 32) * (int)(var27 >> 32) * (int)(var27 >> 32)) % 3;
            int var26;
            int var17 = var26 = var25 - 1;
            var26 = var25 * var17;
            int var41;
            var17 = var41 = var26 % 2;
            if (var10000 == 0 + (var17 - 0)) {
               break;
            }
         }

         Object var5 = var4.remove();
         var10000 = var5.equals(arg1);
         int var19 = (int)(var27 >> 32) - 1;
         int var10 = (int)(var27 >> 32) * var19;
         var19 = var10 % 2;
         if (var10000 + (var19 - 0) != 0) {
            var10000 = (int)var27 * ((int)var27 + 1) % 2;
            int var11 = (int)(var27 >> 32) - 1;
            var11 = (int)(var27 >> 32) * var11;
            int var20 = var11 % 2;
            if (var10000 == 0 + (var20 - 0)) {
               var3 = this.reconstructPath$((V)arg0, (V)var5);
               break;
            }
         }

         Iterator var7 = this.neighbors((V)var5).iterator();

         while(true) {
            var10000 = var7.hasNext();
            int var23 = (int)(var27 >> 32) - 1;
            int var14 = (int)(var27 >> 32) * var23;
            var14 = var23 = var14 % 2;
            if (var10000 + (var14 - 0) == 0) {
               var10000 = ((int)(var27 >> 32) - (int)(var27 >> 32) * (int)(var27 >> 32) * (int)(var27 >> 32)) % 3;
               int var24 = (int)var27 - 1;
               var24 = (int)var27 * var24;
               var24 %= 2;
               if (var10000 == 0 + (var24 - 0)) {
                  break;
               }
            }

            Object var6 = var7.next();
            Vertex var8 = this.vertexInfo((V)var6);
            var10000 = var8.visited();
            int var21 = (int)var27 - 1;
            int var12 = (int)(var27 >> 32) * var21;
            var21 = var12 % 2;
            if (var10000 + (var21 - 0) == 0) {
               var10000 = (int)var27 * ((int)var27 + 1) % 2;
               int var22 = (int)(var27 >> 32) - 1;
               int var13 = (int)(var27 >> 32) * var22;
               var13 = var22 = var13 % 2;
               if (var10000 == 0 + (var13 - 0)) {
                  var8.setVisited(true);
                  var8.setPrevious(var5);
                  var4.add(var6);
               }
            }
         }
      }

      return var3;
   }

   public List<V> reconstructPath$(V arg0, V arg1) {
      long var10 = 1L;
      byte var7 = 69;
      byte var4 = 69;
      LinkedList var3 = new LinkedList();

      while(true) {
         int var10000 = arg1.equals(arg0);
         int var10001 = var4 - 1;
         var10 ^= ((long)(var4 - 1) << 32 ^ var10) & -1L << 32;
         var10001 = var7 * (int)(var10 >> 32);
         var10 ^= ((long)(var7 * (int)(var10 >> 32)) << 32 ^ var10) & -1L << 32;
         var10 ^= ((long)((int)(var10 >> 32) % 2) << 32 ^ var10) & -1L << 32;
         if (var10000 + ((int)(var10 >> 32) - 0) != 0) {
            var10000 = (var7 - var7 * var7 * var7) % 3;
            int var10002 = var4 - 1;
            var10 ^= ((long)(var4 - 1) ^ var10) & -1L >>> 32;
            long var15 = var10 ^ ((long)(var4 * (int)var10) ^ var10) & -1L >>> 32;
            int var6 = var4 * (int)var10;
            var10002 = var6 % 2;
            var10 = var15 ^ ((long)(var6 % 2) ^ var15) & -1L >>> 32;
            if (var10000 == 0 + ((int)var10 - 0)) {
               var3.add(0, arg0);
               return var3;
            }
         }

         var3.add(0, arg1);
         arg1 = this.vertexInfo((V)arg1).previous();
      }
   }

   private class VertexCostComparator implements Comparator<V> {
      public static Object foo;

      public VertexCostComparator() {
      }

      public int compare(V arg0, V arg1) {
         long var5 = 1L;
         var5 ^= ((long)52 ^ var5) & -1L >>> 32;
         var5 ^= ((long)52 << 32 ^ var5) & -1L << 32;
         return SearchableGraph.this.vertexInfo((V)arg0).cost() - SearchableGraph.this.vertexInfo((V)arg1).cost();
      }
   }
}
