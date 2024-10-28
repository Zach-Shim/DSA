import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class AbstractGraph<V, E> implements Graph<V, E> {
   public boolean directed;
   public boolean weighted;
   public Table<V, V, Edge<V, E>> adjacencyMap;
   public Map<V, Vertex<V>> vertices;
   public Multimap<E, Edge<V, E>> edges;
   public long version;
   public static Object foo;

   public AbstractGraph() {
      this(false, false);
   }

   public AbstractGraph(boolean arg0, boolean arg1) {
      long var8 = 1L;
      int var6;
      var8 ^= ((long)(var6 = (int)(Math.random() * 2.0)) << 32 ^ var8) & -1L << 32;
      arg1 ^= var6;
      var8 ^= ((long)((int)(Math.random() * 2.0)) ^ var8) & -1L >>> 32;
      arg0 ^= (int)var8;
      super();
      this.directed = (boolean)(arg0 ^ (int)var8);
      this.weighted = (boolean)(arg1 ^ (int)(var8 >> 32));
      this.adjacencyMap = HashBasedTable.create();
      this.vertices = new HashMap();
      this.edges = HashMultimap.create();
      this.version = 0L;
   }

   @Override
   public void addEdge(V arg0, V arg1) {
      this.addEdge((V)arg0, (V)arg1, (E)null, 1);
   }

   @Override
   public void addEdge(V arg0, V arg1, E arg2) {
      this.addEdge((V)arg0, (V)arg1, (E)arg2, 1);
   }

   @Override
   public void addEdge(V arg0, V arg1, int arg2) {
      this.addEdge((V)arg0, (V)arg1, (E)null, arg2);
   }

   @Override
   public void addEdge(V arg0, V arg1, E arg2, int arg3) {
      long var16 = 1L;
      this.checkVertices((V)arg0, (V)arg1);
      checkForNegative(arg3);
      int var11;
      int var6 = var11 = arg3 - 1;
      var11 = arg3 * var6;
      int var24;
      var6 = var24 = var11 % 2;
      if (this.weighted + (var6 - 0) == 0) {
         int var12;
         int var7 = var12 = arg3 - 1;
         var12 = arg3 * var7;
         int var26;
         var7 = var26 = var12 % 2;
         if (arg3 != 1 + (var7 - 0)) {
            throw new IllegalArgumentException("Unweighted graph cannot accept edge weight of " + arg3 + " (must be " + 1 + ")");
         }
      }

      Edge var5 = null;
      byte var10000 = this.containsEdge((V)arg0, (V)arg1);
      int var13;
      var16 ^= ((long)(var13 = arg3 - 1) << 32 ^ var16) & -1L << 32;
      var16 ^= ((long)(var13 = arg3 * (int)(var16 >> 32)) << 32 ^ var16) & -1L << 32;
      var16 ^= ((long)((int)(var16 >> 32) % 2) << 32 ^ var16) & -1L << 32;
      if (var10000 + ((int)(var16 >> 32) - 0) != 0) {
         var5 = this.getEdge$((V)arg0, (V)arg1);
         this.edges.remove(arg2, var5);
         var5.setEdge(arg2);
         var5.setWeight(arg3);
         this.edges.put(arg2, var5);
      } else {
         var16 ^= ((long)(arg3 - 1) ^ var16) & -1L >>> 32;
         int var9 = arg3 - 1;
         int var10001 = arg3 * var9;
         var16 ^= ((long)(arg3 * var9) ^ var16) & -1L >>> 32;
         var16 ^= ((long)((int)var16 % 2) ^ var16) & -1L >>> 32;
         if (this.weighted + ((int)var16 - 0) != 0) {
            var5 = new Edge<>(arg0, arg1, arg2, arg3);
         } else {
            var5 = new Edge<>(arg0, arg1, arg2);
         }

         this.adjacencyMap.put(arg0, arg1, var5);
         if (foo != null) {
            foo = new Object();
         }

         int var15;
         int var10 = var15 = arg3 - 1;
         var10 = var15 = arg3 * var10;
         var15 = var10 % 2;
         if (this.directed + (var15 - 0) == 0) {
            this.adjacencyMap.put(arg1, arg0, var5);
         }

         this.edges.put(arg2, var5);
      }

      ++this.version;
   }

   @Override
   public void addVertex(V arg0) {
      checkForNull(arg0);
      if (this.containsVertex((V)arg0) + 0 == 0) {
         this.vertices.put(arg0, new Vertex<>(arg0));
         ++this.version;
      }

   }

   @Override
   public void clear() {
      this.vertices.clear();
      this.clearEdges();
   }

   @Override
   public void clearEdges() {
      if (foo != null) {
         foo = new Object();
      }

      this.adjacencyMap.clear();
      this.edges.clear();
      ++this.version;
   }

   @Override
   public boolean containsEdge(E arg0) {
      return this.edges.containsKey(arg0);
   }

   @Override
   public boolean containsEdge(V arg0, V arg1) {
      return this.adjacencyMap.contains(arg0, arg1) + 0 != 0 || this.directed + 0 == 0 && this.adjacencyMap.contains(arg1, arg0) + 0 != 0;
   }

   @Override
   public boolean containsVertex(V arg0) {
      return this.vertices.containsKey(arg0);
   }

   @Override
   public int cost(List<V> arg0) {
      long var13 = 1L;
      checkForNull(arg0);
      if (arg0.isEmpty() + 0 != 0) {
         return 0;
      } else {
         Object var3 = null;
         var13 ^= ((long)0 << 32 ^ var13) & -1L << 32;
         int var2 = 0;
         Iterator var5 = arg0.iterator();

         while(true) {
            byte var10000 = var5.hasNext();
            int var12 = (int)(var13 >> 32) - 1;
            int var8 = (int)(var13 >> 32) * var12;
            var8 = var12 = var8 % 2;
            if (var10000 + (var8 - 0) == 0) {
               return var2;
            }

            Object var4 = var5.next();
            checkForNull(var4);
            this.checkVertex((V)var4);
            if (var3 != null) {
               int var10;
               int var6 = var10 = this.edgeWeight((V)var3, (V)var4);
               int var11;
               var13 ^= ((long)(var11 = (int)(var13 >> 32) - 1) ^ var13) & -1L >>> 32;
               var13 ^= ((long)((int)(var13 >> 32) * var11) ^ var13) & -1L >>> 32;
               var13 ^= ((long)((int)var13 % 2) ^ var13) & -1L >>> 32;
               if (var6 + ((int)var13 - 0) < 0) {
                  throw new IllegalArgumentException("no edge between " + var3 + " and " + var4);
               }

               var13 ^= ((long)((int)(var13 >> 32) + var10) << 32 ^ var13) & -1L << 32;
               var2 = (int)(var13 >> 32) + var10;
            }

            var3 = var4;
         }
      }
   }

   @Override
   public int degree(V arg0) {
      return this.outDegree((V)arg0);
   }

   @Override
   public E edge(V arg0, V arg1) {
      return this.containsEdge((V)arg0, (V)arg1) + 0 != 0 ? this.getEdge$((V)arg0, (V)arg1).edge() : null;
   }

   @Override
   public int edgeCount() {
      return this.edges.size();
   }

   @Override
   public Collection<E> edges() {
      return new AbstractGraph.EdgeCollection(null);
   }

   @Override
   public int edgeWeight(V arg0, V arg1) {
      return this.containsEdge((V)arg0, (V)arg1) + 0 != 0 ? this.getEdge$((V)arg0, (V)arg1).weight() : -1;
   }

   public boolean equals(Object arg0) {
      if ((arg0 instanceof AbstractGraph) + 0 != 0) {
         AbstractGraph var2 = (AbstractGraph)arg0;
         return this.directed == var2.directed + 0
            && this.weighted == var2.weighted + 0
            && this.adjacencyMap.equals(var2.adjacencyMap) + 0 != 0
            && this.vertices.equals(var2.vertices) + 0 != 0;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return 13 * Boolean.valueOf(this.directed).hashCode()
         + 37 * Boolean.valueOf(this.weighted).hashCode()
         + 51 * this.adjacencyMap.hashCode()
         + 117 * this.vertices.hashCode();
   }

   @Override
   public int inDegree(V arg0) {
      return this.adjacencyMap.column(arg0).size();
   }

   @Override
   public boolean isDirected() {
      return this.directed;
   }

   @Override
   public boolean isEmpty() {
      return this.vertices.isEmpty();
   }

   @Override
   public boolean isWeighted() {
      return this.weighted;
   }

   @Override
   public Set<V> neighbors(V arg0) {
      this.checkVertex((V)arg0);
      return new AbstractGraph.NeighborSet(arg0);
   }

   @Override
   public int outDegree(V arg0) {
      return this.adjacencyMap.row(arg0).size();
   }

   @Override
   public void removeEdge(E arg0) {
      long var7 = 1L;
      Iterator var2 = this.adjacencyMap.values().iterator();

      while(var2.hasNext() + 0 != 0) {
         Edge var3 = (Edge)var2.next();
         Object var4 = var3.edge();
         if (arg0 == var4 || arg0 != null && var4 != null && arg0.equals(var4) + 0 != 0) {
            this.removeEdge((V)var3.start(), (V)var3.end());
            break;
         }
      }

   }

   @Override
   public void removeEdge(V arg0, V arg1) {
      if (this.containsEdge((V)arg0, (V)arg1) + 0 != 0) {
         Edge var3 = this.getEdge$((V)arg0, (V)arg1);
         this.adjacencyMap.remove(arg0, arg1);
         if (this.directed + 0 == 0) {
            this.adjacencyMap.remove(arg1, arg0);
         }

         this.edges.remove(var3.edge(), var3);
         ++this.version;
      }

   }

   @Override
   public void removeVertex(V arg0) {
      checkForNull(arg0);
      if (this.containsVertex((V)arg0) + 0 != 0) {
         this.removeVertexHelper$((V)arg0);
         this.vertices.remove(arg0);
         ++this.version;
      }

   }

   @Override
   public String toString() {
      long var14 = 1L;
      StringBuilder var1 = new StringBuilder(65536);
      var1.append("{V={");
      var14 ^= ((long)1 ^ var14) & -1L >>> 32;
      var14 ^= ((long)1 << 32 ^ var14) & -1L << 32;
      Iterator var4 = this.vertices().iterator();

      while(true) {
         int var10000 = var4.hasNext();
         if (foo != null) {
            foo = new Object();
         }

         int var11 = (int)var14 - 1;
         var11 = (int)(var14 >> 32) * var11;
         var11 %= 2;
         if (var10000 + (var11 - 0) == 0) {
            var1.append("}, E={");
            var14 ^= ((long)1 ^ var14) & -1L >>> 32;
            var14 ^= ((long)1 << 32 ^ var14) & -1L << 32;
            var4 = this.adjacencyMap.values().iterator();

            while(true) {
               var10000 = var4.hasNext();
               int var13 = (int)(var14 >> 32) - 1;
               var13 = (int)(var14 >> 32) * var13;
               var13 %= 2;
               if (var10000 + (var13 - 0) == 0) {
                  var1.append("}}");
                  return var1.toString();
               }

               Edge var16 = (Edge)var4.next();
               var10000 = (int)(var14 >> 32);
               int var7 = (int)var14 - 1;
               int var12 = (int)(var14 >> 32) * var7;
               var12 %= 2;
               if (var10000 + (var12 - 0) == 0) {
                  if (foo != null) {
                     foo = new Object();
                  }

                  var1.append(", ");
               }

               var14 ^= ((long)0 ^ var14) & -1L >>> 32;
               var14 ^= ((long)0 << 32 ^ var14) & -1L << 32;
               var1.append(var16);
            }
         }

         Object var3 = var4.next();
         var10000 = (int)(var14 >> 32);
         int var5 = (int)var14 - 1;
         var5 = (int)var14 * var5;
         int var10;
         var5 = var10 = var5 % 2;
         if (var10000 + (var5 - 0) == 0) {
            var1.append(", ");
         }

         var14 ^= ((long)0 ^ var14) & -1L >>> 32;
         var14 ^= ((long)0 << 32 ^ var14) & -1L << 32;
         var1.append(var3);
      }
   }

   @Override
   public String toStringDetailed() {
      StringBuilder var1 = new StringBuilder(65536);
      var1.append("Graph{\n").append("\tvertices:\n");
      Iterator var3 = this.vertices().iterator();

      while(var3.hasNext() + 0 != 0) {
         Object var2 = var3.next();
         var1.append("\t\t").append(this.vertices.get(var2)).append(" -> neighbors: ").append(this.neighbors((V)var2)).append('\n');
      }

      var1.append("\tedges:\n");
      var3 = this.adjacencyMap.values().iterator();

      while(var3.hasNext() + 0 != 0) {
         Edge var4 = (Edge)var3.next();
         var1.append("\t\t").append(var4).append('\n');
      }

      var1.append('}');
      return var1.toString();
   }

   @Override
   public int vertexCount() {
      return this.vertices.size();
   }

   @Override
   public Set<V> vertices() {
      return new AbstractGraph.VertexSet(null);
   }

   public static void checkForNegative(int arg0) {
      long var3 = 1L;
      var3 ^= ((long)(arg0 - 1) ^ var3) & -1L >>> 32;
      var3 ^= ((long)(arg0 - 1) << 32 ^ var3) & -1L << 32;
      long var7 = var3 ^ ((long)(arg0 * (int)var3) ^ var3) & -1L >>> 32;
      var3 = var7 ^ ((long)(arg0 * (int)var3) << 32 ^ var7) & -1L << 32;
      long var9 = var3 ^ ((long)((int)(var3 >> 32) % 2) ^ var3) & -1L >>> 32;
      var3 = var9 ^ ((long)((int)(var3 >> 32) % 2) << 32 ^ var9) & -1L << 32;
      if (arg0 + ((int)var3 - 0) < 0) {
         throw new IllegalArgumentException("argument cannot be negative: " + arg0);
      }
   }

   public static void checkForNull(Object... arg0) {
      long var9 = 1L;
      Object[] var4 = arg0;
      int var6;
      int var3 = var6 = arg0.length;
      int var7 = 0;
      var9 ^= ((long)0 ^ var9) & -1L >>> 32;

      while(true) {
         int var10000 = (int)var9;
         int var8;
         var9 ^= ((long)(var8 = var7 - 1) << 32 ^ var9) & -1L << 32;
         var9 ^= ((long)((int)var9 * (int)(var9 >> 32)) << 32 ^ var9) & -1L << 32;
         var9 ^= ((long)((int)(var9 >> 32) % 2) << 32 ^ var9) & -1L << 32;
         if (var10000 >= var3 + ((int)(var9 >> 32) - 0)) {
            return;
         }

         Object var1 = var4[var7];
         if (var1 == null) {
            throw new NullPointerException("argument must not be null");
         }

         ++var7;
         var9 ^= (var9 ^ var9 + (long)1) & -1L >>> 32;
      }
   }

   public void checkVertex(V arg0) {
      if (this.containsVertex((V)arg0) + 0 == 0) {
         throw new IllegalArgumentException("Vertex not found in graph: " + arg0);
      }
   }

   public void checkVertices(V arg0, V arg1) {
      this.checkVertex((V)arg0);
      this.checkVertex((V)arg1);
   }

   public void clearVertexInfo() {
      Iterator var2 = this.vertices.values().iterator();

      while(var2.hasNext() + 0 != 0) {
         Vertex var1 = (Vertex)var2.next();
         var1.clear();
      }

   }

   public Vertex<V> vertexInfo(V arg0) {
      this.checkVertex((V)arg0);
      return (Vertex<V>)this.vertices.get(arg0);
   }

   public Map<V, Vertex<V>> vertexInfos() {
      return Collections.unmodifiableMap(this.vertices);
   }

   public Edge<V, E> getEdge$(V arg0, V arg1) {
      Edge var3 = (Edge)this.adjacencyMap.get(arg0, arg1);
      if (this.directed + 0 == 0 && var3 == null) {
         var3 = (Edge)this.adjacencyMap.get(arg1, arg0);
      }

      return var3;
   }

   public void removeVertexHelper$(V arg0) {
      Map var2 = this.adjacencyMap.row(arg0);
      Iterator var4 = var2.values().iterator();

      while(var4.hasNext() + 0 != 0) {
         Edge var3 = (Edge)var4.next();
         this.edges.remove(var3.edge(), var3);
      }

      var2.clear();
      Map var6 = this.adjacencyMap.column(arg0);
      if (this.directed + 0 == 0) {
         Iterator var5 = var6.values().iterator();

         while(var5.hasNext() + 0 != 0) {
            Edge var7 = (Edge)var5.next();
            this.edges.remove(var7.edge(), var7);
         }
      }

      var6.clear();
      this.vertices.remove(arg0);
   }

   private class EdgeCollection extends AbstractCollection<E> {
      public static Object foo;

      public EdgeCollection() {
      }

      public Iterator<E> iterator() {
         long var3 = 1L;
         var3 ^= ((long)60 ^ var3) & -1L >>> 32;
         var3 ^= ((long)60 << 32 ^ var3) & -1L << 32;
         return new AbstractGraph.EdgeCollection.EdgeIterator();
      }

      public void clear() {
         long var3 = 1L;
         var3 ^= ((long)48 ^ var3) & -1L >>> 32;
         var3 ^= ((long)48 << 32 ^ var3) & -1L << 32;
         AbstractGraph.this.clearEdges();
      }

      public int size() {
         long var3 = 1L;
         if (foo != null) {
            foo = new Object();
         }

         var3 ^= ((long)29 << 32 ^ var3) & -1L << 32;
         var3 ^= ((long)29 ^ var3) & -1L >>> 32;
         return AbstractGraph.this.edgeCount();
      }

      private class EdgeIterator implements Iterator<E> {
         public Iterator<Edge<V, E>> innerItr = AbstractGraph.EdgeCollection.access$1(EdgeCollection.this).edges.values().iterator();
         public long itrVersion = AbstractGraph.EdgeCollection.access$1(EdgeCollection.this).version;
         public Edge<V, E> last = null;
         public static Object foo;

         public EdgeIterator() {
         }

         public boolean hasNext() {
            long var3 = 1L;
            var3 ^= ((long)15 ^ var3) & -1L >>> 32;
            var3 ^= ((long)15 << 32 ^ var3) & -1L << 32;
            this.checkVersion$();
            return this.innerItr.hasNext();
         }

         public E next() {
            long var5 = 1L;
            var5 ^= ((long)53 ^ var5) & -1L >>> 32;
            var5 ^= ((long)53 << 32 ^ var5) & -1L << 32;
            this.checkVersion$();
            Edge var1 = (Edge)this.innerItr.next();
            this.last = var1;
            return (E)var1.edge();
         }

         public void remove() {
            long var7 = 1L;
            byte var4 = 91;
            byte var1 = 91;
            this.checkVersion$();
            this.innerItr.remove();
            AbstractGraph.EdgeCollection.access$1(EdgeCollection.this).adjacencyMap.remove(this.last.start(), this.last.end());
            int var10000 = AbstractGraph.EdgeCollection.access$1(EdgeCollection.this).directed;
            int var5;
            var7 ^= ((long)(var5 = var4 - 1) ^ var7) & -1L >>> 32;
            var7 ^= ((long)(var5 = var1 * (int)var7) ^ var7) & -1L >>> 32;
            var7 ^= ((long)(var5 = (int)var7 % 2) ^ var7) & -1L >>> 32;
            if (var10000 + (var5 - 0) == 0) {
               var10000 = (var1 - var1 * var1 * var1) % 3;
               int var10002 = var4 - 1;
               var7 ^= ((long)(var4 - 1) << 32 ^ var7) & -1L << 32;
               var10002 = var4 * (int)(var7 >> 32);
               var7 ^= ((long)(var4 * (int)(var7 >> 32)) << 32 ^ var7) & -1L << 32;
               var7 ^= ((long)((int)(var7 >> 32) % 2) << 32 ^ var7) & -1L << 32;
               if (var10000 == 0 + ((int)(var7 >> 32) - 0)) {
                  AbstractGraph.EdgeCollection.access$1(EdgeCollection.this).adjacencyMap.remove(this.last.end(), this.last.start());
               }
            }

         }

         public void checkVersion$() {
            long var7 = 1L;
            byte var4 = 19;
            byte var1 = 19;
            long var18;
            int var10000 = (var18 = AbstractGraph.EdgeCollection.access$1(EdgeCollection.this).version - this.itrVersion) == 0L ? 0 : (var18 < 0L ? -1 : 1);
            int var5;
            var7 ^= ((long)(var5 = var1 - 1) << 32 ^ var7) & -1L << 32;
            var7 ^= ((long)(var5 = var4 * (int)(var7 >> 32)) << 32 ^ var7) & -1L << 32;
            var7 ^= ((long)((int)(var7 >> 32) % 2) << 32 ^ var7) & -1L << 32;
            if (var10000 + ((int)(var7 >> 32) - 0) != 0) {
               var10000 = var1 * var1 / 2 % 2;
               int var6;
               var7 ^= ((long)(var6 = var4 - 1) ^ var7) & -1L >>> 32;
               var7 ^= ((long)(var6 = var4 * (int)var7) ^ var7) & -1L >>> 32;
               var7 ^= ((long)((int)var7 % 2) ^ var7) & -1L >>> 32;
               if (var10000 == 0 + ((int)var7 - 0)) {
                  throw new ConcurrentModificationException();
               }
            }

         }
      }
   }

   private class NeighborSet extends AbstractSet<V> {
      public Set<V> row;
      public static Object foo;

      public NeighborSet(V arg1) {
         this.row = AbstractGraph.this.adjacencyMap.row(arg1).keySet();
      }

      public void clear() {
         long var3 = 1L;
         var3 ^= ((long)77 ^ var3) & -1L >>> 32;
         var3 ^= ((long)77 << 32 ^ var3) & -1L << 32;
         super.clear();
      }

      public Iterator<V> iterator() {
         long var3 = 1L;
         var3 ^= ((long)77 ^ var3) & -1L >>> 32;
         var3 ^= ((long)77 << 32 ^ var3) & -1L << 32;
         return new AbstractGraph.NeighborSet.NeighborIterator();
      }

      public int size() {
         long var3 = 1L;
         var3 ^= ((long)73 ^ var3) & -1L >>> 32;
         var3 ^= ((long)73 << 32 ^ var3) & -1L << 32;
         return this.row.size();
      }

      private class NeighborIterator implements Iterator<V> {
         public Iterator<V> innerItr = NeighborSet.this.row.iterator();
         public long itrVersion = AbstractGraph.NeighborSet.access$0(NeighborSet.this).version;
         public V last = (V)null;
         public static Object foo;

         public NeighborIterator() {
         }

         public boolean hasNext() {
            long var3 = 1L;
            var3 ^= ((long)95 ^ var3) & -1L >>> 32;
            var3 ^= ((long)95 << 32 ^ var3) & -1L << 32;
            this.checkVersion$$();
            return this.innerItr.hasNext();
         }

         public V next() {
            long var4 = 1L;
            var4 ^= ((long)44 ^ var4) & -1L >>> 32;
            var4 ^= ((long)44 << 32 ^ var4) & -1L << 32;
            this.checkVersion$$();
            Object var1 = this.innerItr.next();
            this.last = (V)var1;
            return (V)var1;
         }

         public void remove() {
            long var3 = 1L;
            var3 ^= ((long)84 ^ var3) & -1L >>> 32;
            var3 ^= ((long)84 << 32 ^ var3) & -1L << 32;
            this.checkVersion$$();
            this.innerItr.remove();
            AbstractGraph.NeighborSet.access$0(NeighborSet.this).removeVertexHelper$(this.last);
            this.last = null;
         }

         public void checkVersion$$() {
            long var7 = 1L;
            byte var4 = 75;
            byte var1 = 75;
            long var17;
            int var10000 = (var17 = AbstractGraph.NeighborSet.access$0(NeighborSet.this).version - this.itrVersion) == 0L ? 0 : (var17 < 0L ? -1 : 1);
            int var5;
            var7 ^= ((long)(var5 = var1 - 1) << 32 ^ var7) & -1L << 32;
            int var9;
            var7 ^= ((long)(var9 = var4 * var5) << 32 ^ var7) & -1L << 32;
            var7 ^= ((long)((int)(var7 >> 32) % 2) << 32 ^ var7) & -1L << 32;
            if (var10000 + ((int)(var7 >> 32) - 0) != 0) {
               var10000 = var1 * var1 / 2 % 2;
               var7 ^= ((long)(var4 - 1) ^ var7) & -1L >>> 32;
               int var3 = var4 - 1;
               int var10002 = var4 * var3;
               var7 ^= ((long)(var4 * var3) ^ var7) & -1L >>> 32;
               var7 ^= ((long)((int)var7 % 2) ^ var7) & -1L >>> 32;
               if (var10000 == 0 + ((int)var7 - 0)) {
                  throw new ConcurrentModificationException();
               }
            }

         }
      }
   }

   private class VertexSet extends AbstractSet<V> {
      public static Object foo;

      public VertexSet() {
      }

      public boolean add(V arg0) {
         long var4 = 1L;
         var4 ^= ((long)20 ^ var4) & -1L >>> 32;
         var4 ^= ((long)20 << 32 ^ var4) & -1L << 32;
         AbstractGraph.this.addVertex((V)arg0);
         return true;
      }

      public void clear() {
         long var3 = 1L;
         var3 ^= ((long)43 ^ var3) & -1L >>> 32;
         var3 ^= ((long)43 << 32 ^ var3) & -1L << 32;
         if (foo != null) {
            foo = new Object();
         }

         AbstractGraph.this.clear();
      }

      public Iterator<V> iterator() {
         long var3 = 1L;
         var3 ^= ((long)88 ^ var3) & -1L >>> 32;
         var3 ^= ((long)88 << 32 ^ var3) & -1L << 32;
         return new AbstractGraph.VertexSet.VertexIterator();
      }

      public int size() {
         long var3 = 1L;
         var3 ^= ((long)24 ^ var3) & -1L >>> 32;
         var3 ^= ((long)24 << 32 ^ var3) & -1L << 32;
         return AbstractGraph.this.vertexCount();
      }

      private class VertexIterator implements Iterator<V> {
         public Iterator<Vertex<V>> innerItr = AbstractGraph.VertexSet.access$1(VertexSet.this).vertices.values().iterator();
         public long itrVersion = AbstractGraph.VertexSet.access$1(VertexSet.this).version;
         public Vertex<V> last = null;
         public static Object foo;

         public VertexIterator() {
         }

         public boolean hasNext() {
            long var3 = 1L;
            var3 ^= ((long)52 ^ var3) & -1L >>> 32;
            var3 ^= ((long)52 << 32 ^ var3) & -1L << 32;
            this.checkVersion$$$();
            return this.innerItr.hasNext();
         }

         public V next() {
            long var4 = 1L;
            var4 ^= ((long)60 ^ var4) & -1L >>> 32;
            var4 ^= ((long)60 << 32 ^ var4) & -1L << 32;
            this.checkVersion$$$();
            Vertex var1 = (Vertex)this.innerItr.next();
            this.last = var1;
            return (V)var1.vertex();
         }

         public void remove() {
            long var3 = 1L;
            var3 ^= ((long)3 << 32 ^ var3) & -1L << 32;
            var3 ^= ((long)3 ^ var3) & -1L >>> 32;
            this.checkVersion$$$();
            this.innerItr.remove();
            AbstractGraph.VertexSet.access$1(VertexSet.this).removeVertexHelper$(this.last.vertex());
            this.last = null;
         }

         public void checkVersion$$$() {
            long var7 = 1L;
            byte var4 = 82;
            byte var1 = 82;
            long var18;
            int var10000 = (var18 = AbstractGraph.VertexSet.access$1(VertexSet.this).version - this.itrVersion) == 0L ? 0 : (var18 < 0L ? -1 : 1);
            int var10001 = var4 - 1;
            var7 ^= ((long)(var4 - 1) << 32 ^ var7) & -1L << 32;
            long var10 = var7 ^ ((long)(var4 * (int)(var7 >> 32)) << 32 ^ var7) & -1L << 32;
            int var2 = var4 * (int)(var7 >> 32);
            var10001 = var2 % 2;
            var7 = var10 ^ ((long)(var2 % 2) << 32 ^ var10) & -1L << 32;
            if (var10000 + ((int)(var7 >> 32) - 0) != 0) {
               var10000 = (var1 - var1 * var1 * var1) % 3;
               var7 ^= ((long)(var1 - 1) ^ var7) & -1L >>> 32;
               int var3 = var1 - 1;
               int var10002 = var4 * var3;
               var7 ^= ((long)(var4 * var3) ^ var7) & -1L >>> 32;
               var7 ^= ((long)((int)var7 % 2) ^ var7) & -1L >>> 32;
               if (var10000 == 0 + ((int)var7 - 0)) {
                  throw new ConcurrentModificationException();
               }
            }

         }
      }
   }
}
