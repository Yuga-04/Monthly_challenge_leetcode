# 📌 Day 21: 1912. Design Movie Rental System 🎯

**🔗 LeetCode Link:** [1912. Design Movie Rental System](https://leetcode.com/problems/design-movie-rental-system/)

---

## 🧩 Problem Description

<p>You have a movie renting company consisting of <code>n</code> shops. You want to implement a renting system that supports searching for, booking, and returning movies. The system should also support generating a report of the currently rented movies.</p>

<p>Each movie is given as a 2D integer array <code>entries</code> where <code>entries[i] = [shop<sub>i</sub>, movie<sub>i</sub>, price<sub>i</sub>]</code> indicates that there is a copy of movie <code>movie<sub>i</sub></code> at shop <code>shop<sub>i</sub></code> with a rental price of <code>price<sub>i</sub></code>. Each shop carries <strong>at most one</strong> copy of a movie <code>movie<sub>i</sub></code>.</p>

<p>The system should support the following functions:</p>

<ul>
	<li><strong>Search</strong>: Finds the <strong>cheapest 5 shops</strong> that have an <strong>unrented copy</strong> of a given movie. The shops should be sorted by <strong>price</strong> in ascending order, and in case of a tie, the one with the <strong>smaller </strong><code>shop<sub>i</sub></code> should appear first. If there are less than 5 matching shops, then all of them should be returned. If no shop has an unrented copy, then an empty list should be returned.</li>
	<li><strong>Rent</strong>: Rents an <strong>unrented copy</strong> of a given movie from a given shop.</li>
	<li><strong>Drop</strong>: Drops off a <strong>previously rented copy</strong> of a given movie at a given shop.</li>
	<li><strong>Report</strong>: Returns the <strong>cheapest 5 rented movies</strong> (possibly of the same movie ID) as a 2D list <code>res</code> where <code>res[j] = [shop<sub>j</sub>, movie<sub>j</sub>]</code> describes that the <code>j<sup>th</sup></code> cheapest rented movie <code>movie<sub>j</sub></code> was rented from the shop <code>shop<sub>j</sub></code>. The movies in <code>res</code> should be sorted by <strong>price </strong>in ascending order, and in case of a tie, the one with the <strong>smaller </strong><code>shop<sub>j</sub></code> should appear first, and if there is still tie, the one with the <strong>smaller </strong><code>movie<sub>j</sub></code> should appear first. If there are fewer than 5 rented movies, then all of them should be returned. If no movies are currently being rented, then an empty list should be returned.</li>
</ul>

<p>Implement the <code>MovieRentingSystem</code> class:</p>

<ul>
	<li><code>MovieRentingSystem(int n, int[][] entries)</code> Initializes the <code>MovieRentingSystem</code> object with <code>n</code> shops and the movies in <code>entries</code>.</li>
	<li><code>List&lt;Integer&gt; search(int movie)</code> Returns a list of shops that have an <strong>unrented copy</strong> of the given <code>movie</code> as described above.</li>
	<li><code>void rent(int shop, int movie)</code> Rents the given <code>movie</code> from the given <code>shop</code>.</li>
	<li><code>void drop(int shop, int movie)</code> Drops off a previously rented <code>movie</code> at the given <code>shop</code>.</li>
	<li><code>List&lt;List&lt;Integer&gt;&gt; report()</code> Returns a list of cheapest <strong>rented</strong> movies as described above.</li>
</ul>

<p><strong>Note:</strong> The test cases will be generated such that <code>rent</code> will only be called if the shop has an <strong>unrented</strong> copy of the movie, and <code>drop</code> will only be called if the shop had <strong>previously rented</strong> out the movie.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Hash Table
- Design
- Heap (Priority Queue)
- Ordered Set
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input</strong>
[&quot;MovieRentingSystem&quot;, &quot;search&quot;, &quot;rent&quot;, &quot;rent&quot;, &quot;report&quot;, &quot;drop&quot;, &quot;search&quot;]
[[3, [[0, 1, 5], [0, 2, 6], [0, 3, 7], [1, 1, 4], [1, 2, 7], [2, 1, 5]]], [1], [0, 1], [1, 2], [], [1, 2], [2]]
<strong>Output</strong>
[null, [1, 0, 2], null, null, [[0, 1], [1, 2]], null, [0, 1]]

<strong>Explanation</strong>
MovieRentingSystem movieRentingSystem = new MovieRentingSystem(3, [[0, 1, 5], [0, 2, 6], [0, 3, 7], [1, 1, 4], [1, 2, 7], [2, 1, 5]]);
movieRentingSystem.search(1);  // return [1, 0, 2], Movies of ID 1 are unrented at shops 1, 0, and 2. Shop 1 is cheapest; shop 0 and 2 are the same price, so order by shop number.
movieRentingSystem.rent(0, 1); // Rent movie 1 from shop 0. Unrented movies at shop 0 are now [2,3].
movieRentingSystem.rent(1, 2); // Rent movie 2 from shop 1. Unrented movies at shop 1 are now [1].
movieRentingSystem.report();   // return [[0, 1], [1, 2]]. Movie 1 from shop 0 is cheapest, followed by movie 2 from shop 1.
movieRentingSystem.drop(1, 2); // Drop off movie 2 at shop 1. Unrented movies at shop 1 are now [1,2].
movieRentingSystem.search(2);  // return [0, 1]. Movies of ID 2 are unrented at shops 0 and 1. Shop 0 is cheapest, followed by shop 1.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 3 * 10<sup>5</sup></code></li>
	<li><code>1 &lt;= entries.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= shop<sub>i</sub> &lt; n</code></li>
	<li><code>1 &lt;= movie<sub>i</sub>, price<sub>i</sub> &lt;= 10<sup>4</sup></code></li>
	<li>Each shop carries <strong>at most one</strong> copy of a movie <code>movie<sub>i</sub></code>.</li>
	<li>At most <code>10<sup>5</sup></code> calls <strong>in total</strong> will be made to <code>search</code>, <code>rent</code>, <code>drop</code> and <code>report</code>.</li>
</ul>

---

## ✅ Code (Java)

```java
class MovieRentingSystem {
    private static class Node {
        final int shop;
        final int movie;
        final int price;
        Node(int shop, int movie, int price) {
            this.shop = shop;
            this.movie = movie;
            this.price = price;
        }
    }

    // Order: price ↑, shop ↑, movie ↑  (strict: never returns 0 for distinct nodes)
    private static final Comparator<Node> CMP =
        (a, b) -> {
            int c = Integer.compare(a.price, b.price);
            if (c != 0) return c;
            c = Integer.compare(a.shop, b.shop);
            if (c != 0) return c;
            return Integer.compare(a.movie, b.movie);
        };

    // Available copies grouped by movie
    private final Map<Integer, TreeSet<Node>> availableByMovie = new HashMap<>();
    // All currently rented copies
    private final TreeSet<Node> rentedSet = new TreeSet<>(CMP);
    // Quick lookup from (shop, movie) -> Node
    private final Map<Long, Node> byPair = new HashMap<>();

    private static long key(int shop, int movie) {
        return (((long) shop) << 32) ^ (movie & 0xffffffffL);
    }

    public MovieRentingSystem(int n, int[][] entries) {
        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            Node node = new Node(shop, movie, price);
            byPair.put(key(shop, movie), node);
            availableByMovie
                .computeIfAbsent(movie, k -> new TreeSet<>(CMP))
                .add(node);
        }
    }

    // Return up to 5 shops with this movie, cheapest then shop asc.
    public List<Integer> search(int movie) {
        List<Integer> ans = new ArrayList<>(5);
        TreeSet<Node> set = availableByMovie.get(movie);
        if (set == null || set.isEmpty()) return ans;
        Iterator<Node> it = set.iterator();
        for (int i = 0; i < 5 && it.hasNext(); i++) {
            ans.add(it.next().shop);
        }
        return ans;
    }

    // Move (shop,movie) from available -> rented
    public void rent(int shop, int movie) {
        long k = key(shop, movie);
        Node node = byPair.get(k);
        if (node == null) return; // defensive
        TreeSet<Node> set = availableByMovie.get(movie);
        if (set != null) set.remove(node);
        rentedSet.add(node);
    }

    // Move (shop,movie) from rented -> available
    public void drop(int shop, int movie) {
        long k = key(shop, movie);
        Node node = byPair.get(k);
        if (node == null) return; // defensive
        rentedSet.remove(node);
        availableByMovie
            .computeIfAbsent(movie, x -> new TreeSet<>(CMP))
            .add(node);
    }

    // Return up to 5 rented copies [shop, movie], cheapest then shop asc, then movie asc.
    public List<List<Integer>> report() {
        List<List<Integer>> ans = new ArrayList<>(5);
        Iterator<Node> it = rentedSet.iterator();
        for (int i = 0; i < 5 && it.hasNext(); i++) {
            Node n = it.next();
            ans.add(Arrays.asList(n.shop, n.movie));
        }
        return ans;
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input</strong>
[&quot;MovieRentingSystem&quot;, &quot;search&quot;, &quot;rent&quot;, &quot;rent&quot;, &quot;report&quot;, &quot;drop&quot;, &quot;search&quot;]
[[3, [[0, 1, 5], [0, 2, 6], [0, 3, 7], [1, 1, 4], [1, 2, 7], [2, 1, 5]]], [1], [0, 1], [1, 2], [], [1, 2], [2]]
<strong>Output</strong>
[null, [1, 0, 2], null, null, [[0, 1], [1, 2]], null, [0, 1]]
</pre>


