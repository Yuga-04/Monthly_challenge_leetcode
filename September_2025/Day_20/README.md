# 📌 Day 20: 3508. Implement Router 🎯

**🔗 LeetCode Link:** [3508. Implement Router](https://leetcode.com/problems/implement-router/)

---

## 🧩 Problem Description

<p>Design a data structure that can efficiently manage data packets in a network router. Each data packet consists of the following attributes:</p>

<ul>
	<li><code>source</code>: A unique identifier for the machine that generated the packet.</li>
	<li><code>destination</code>: A unique identifier for the target machine.</li>
	<li><code>timestamp</code>: The time at which the packet arrived at the router.</li>
</ul>

<p>Implement the <code>Router</code> class:</p>

<p><code>Router(int memoryLimit)</code>: Initializes the Router object with a fixed memory limit.</p>

<ul>
	<li><code>memoryLimit</code> is the <strong>maximum</strong> number of packets the router can store at any given time.</li>
	<li>If adding a new packet would exceed this limit, the <strong>oldest</strong> packet must be removed to free up space.</li>
</ul>

<p><code>bool addPacket(int source, int destination, int timestamp)</code>: Adds a packet with the given attributes to the router.</p>

<ul>
	<li>A packet is considered a duplicate if another packet with the same <code>source</code>, <code>destination</code>, and <code>timestamp</code> already exists in the router.</li>
	<li>Return <code>true</code> if the packet is successfully added (i.e., it is not a duplicate); otherwise return <code>false</code>.</li>
</ul>

<p><code>int[] forwardPacket()</code>: Forwards the next packet in FIFO (First In First Out) order.</p>

<ul>
	<li>Remove the packet from storage.</li>
	<li>Return the packet as an array <code>[source, destination, timestamp]</code>.</li>
	<li>If there are no packets to forward, return an empty array.</li>
</ul>

<p><code>int getCount(int destination, int startTime, int endTime)</code>:</p>

<ul>
	<li>Returns the number of packets currently stored in the router (i.e., not yet forwarded) that have the specified destination and have timestamps in the inclusive range <code>[startTime, endTime]</code>.</li>
</ul>

<p><strong>Note</strong> that queries for <code>addPacket</code> will be made in increasing order of <code>timestamp</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Hash Table
- Binary Search
- Design
- Queue
- Ordered Set
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong><br />
<span class="example-io">[&quot;Router&quot;, &quot;addPacket&quot;, &quot;addPacket&quot;, &quot;addPacket&quot;, &quot;addPacket&quot;, &quot;addPacket&quot;, &quot;forwardPacket&quot;, &quot;addPacket&quot;, &quot;getCount&quot;]<br />
[[3], [1, 4, 90], [2, 5, 90], [1, 4, 90], [3, 5, 95], [4, 5, 105], [], [5, 2, 110], [5, 100, 110]]</span></p>

<p><strong>Output:</strong><br />
<span class="example-io">[null, true, true, false, true, true, [2, 5, 90], true, 1] </span></p>

<p><strong>Explanation</strong></p>
Router router = new Router(3); // Initialize Router with memoryLimit of 3.<br />
router.addPacket(1, 4, 90); // Packet is added. Return True.<br />
router.addPacket(2, 5, 90); // Packet is added. Return True.<br />
router.addPacket(1, 4, 90); // This is a duplicate packet. Return False.<br />
router.addPacket(3, 5, 95); // Packet is added. Return True<br />
router.addPacket(4, 5, 105); // Packet is added, <code>[1, 4, 90]</code> is removed as number of packets exceeds memoryLimit. Return True.<br />
router.forwardPacket(); // Return <code>[2, 5, 90]</code> and remove it from router.<br />
router.addPacket(5, 2, 110); // Packet is added. Return True.<br />
router.getCount(5, 100, 110); // The only packet with destination 5 and timestamp in the inclusive range <code>[100, 110]</code> is <code>[4, 5, 105]</code>. Return 1.</div>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong><br />
<span class="example-io">[&quot;Router&quot;, &quot;addPacket&quot;, &quot;forwardPacket&quot;, &quot;forwardPacket&quot;]<br />
[[2], [7, 4, 90], [], []]</span></p>

<p><strong>Output:</strong><br />
<span class="example-io">[null, true, [7, 4, 90], []] </span></p>

<p><strong>Explanation</strong></p>
Router router = new Router(2); // Initialize <code>Router</code> with <code>memoryLimit</code> of 2.<br />
router.addPacket(7, 4, 90); // Return True.<br />
router.forwardPacket(); // Return <code>[7, 4, 90]</code>.<br />
router.forwardPacket(); // There are no packets left, return <code>[]</code>.</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= memoryLimit &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= source, destination &lt;= 2 * 10<sup>5</sup></code></li>
	<li><code>1 &lt;= timestamp &lt;= 10<sup>9</sup></code></li>
	<li><code>1 &lt;= startTime &lt;= endTime &lt;= 10<sup>9</sup></code></li>
	<li>At most <code>10<sup>5</sup></code> calls will be made to <code>addPacket</code>, <code>forwardPacket</code>, and <code>getCount</code> methods altogether.</li>
	<li>queries for <code>addPacket</code> will be made in increasing order of <code>timestamp</code>.</li>
</ul>

---

## ✅ Code (Java)

```java
class Router {
    private final int size;
    private final Map<Integer, List<Integer>> counts;
    private final Map<Long, int[]> packets;
    private final Queue<Long> queue;

    public Router(final int memoryLimit) {
        this.size = memoryLimit;
        this.packets = new HashMap<>();
        this.counts = new HashMap<>();
        this.queue = new LinkedList<>();
    }

    public boolean addPacket(final int source, final int destination, final int timestamp) {
        final long key = encode(source, destination, timestamp);

        if(packets.containsKey(key))
            return false;

        if(packets.size() >= size)
            forwardPacket();

        packets.put(key, new int[] { source, destination, timestamp });
        queue.offer(key);

        counts.putIfAbsent(destination, new ArrayList<>());
        counts.get(destination).add(timestamp);

        return true;
    }

    public int[] forwardPacket() {
        if(packets.isEmpty())
            return new int[] {};

        final long key = queue.poll();
        final int[] packet = packets.remove(key);

        if(packet == null)
            return new int[]{};

        final int destination = packet[1];
        final List<Integer> list = counts.get(destination);

        list.remove(0);

        return packet;
    }

    public int getCount(final int destination, final int startTime, final int endTime) {
        final List<Integer> list = counts.get(destination);
        if(list == null || list.isEmpty())
            return 0;

        final int left = lowerBound(list, startTime);
        final int right = upperBound(list, endTime);

        return right - left;
    }

    private long encode(final int source, final int destination, final int timestamp) {
        return ((long)source << 40) | ((long)destination << 20) | timestamp;
    }

    private int lowerBound(final List<Integer> list, final int target) {
        int low = 0, high = list.size();

        while(low < high) {
            final int mid = (low + high) >>> 1;
            if(list.get(mid) < target) low = mid + 1;
            else high = mid;
        }

        return low;
    }

    private int upperBound(final List<Integer> list, final int target) {
        int low = 0, high = list.size();

        while(low < high) {
            final int mid = (low + high) >>> 1;

            if(list.get(mid) <= target)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong><br />
<span class="example-io">[&quot;Router&quot;, &quot;addPacket&quot;, &quot;addPacket&quot;, &quot;addPacket&quot;, &quot;addPacket&quot;, &quot;addPacket&quot;, &quot;forwardPacket&quot;, &quot;addPacket&quot;, &quot;getCount&quot;]<br />
[[3], [1, 4, 90], [2, 5, 90], [1, 4, 90], [3, 5, 95], [4, 5, 105], [], [5, 2, 110], [5, 100, 110]]</span></p>

<p><strong>Output:</strong><br />
<span class="example-io">[null, true, true, false, true, true, [2, 5, 90], true, 1] </span></p>

<p><strong class="example">


</div>
