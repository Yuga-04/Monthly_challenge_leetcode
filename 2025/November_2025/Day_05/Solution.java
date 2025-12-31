public class Solution {
    class Element {
        int value;
        int freq;
        Element(int value, int freq) { this.value = value; this.freq = freq; }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            Element other = (Element) obj;
            return this.value == other.value && this.freq == other.freq;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, freq);
        }
    }

    private final Comparator<Element> comp = (a, b) -> {
        if (a.freq != b.freq) return Integer.compare(b.freq, a.freq);
        if (a.value != b.value) return Integer.compare(b.value, a.value);
        return 0;
    };

    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        Map<Integer, Integer> hmap = new HashMap<>();
        TreeSet<Element> xset = new TreeSet<>(comp);   // top-x elements, size is always x
        TreeSet<Element> remset = new TreeSet<>(comp); 
        long[] ans = new long[n - k + 1];
        long xsum = 0; // running sum 
        int idx = 0;

        for (int i = 0; i < n; ++i) {
            int num = nums[i];
            int prevFreq = hmap.getOrDefault(num, 0);
            // [1,1,2,2,3,4,2,3]
            if (prevFreq > 0) {
                Element old = new Element(num, prevFreq);
                if (xset.contains(old)) {
                    xsum -= (long) old.value * old.freq;
                    xset.remove(old);
                } else {
                    remset.remove(old);
                }
            }
            // [1,1,2,2,3,4,2,3]
            int newFreq = prevFreq + 1;
            hmap.put(num, newFreq);
            Element added = new Element(num, newFreq);
            xset.add(added);
            xsum += (long) added.value * added.freq;

            if (xset.size() > x) {
                Element last = xset.last(); // lowest among top-x
                xsum -= (long) last.value * last.freq;
                xset.remove(last);
                remset.add(last);
            }
             // [1,1,2,2,3,4,2,3]
            if (i >= k) {
                int out = nums[i - k];
                int freqOut = hmap.get(out);
                Element outElem = new Element(out, freqOut);

                if (xset.contains(outElem)) {
                    xsum -= (long) outElem.value * outElem.freq;
                    xset.remove(outElem);
                } else {
                    remset.remove(outElem);
                }

                if (freqOut == 1) {
                    hmap.remove(out);
                } else {
                    int reduced = freqOut - 1;
                    hmap.put(out, reduced);
                    remset.add(new Element(out, reduced));
                }

                while (xset.size() < x && !remset.isEmpty()) {
                    Element promote = remset.first();
                    remset.remove(promote);
                    xset.add(promote);
                    xsum += (long) promote.value * promote.freq;
                }
            }

            if (i >= k - 1) {
                ans[idx++] = xsum;
            }
        }

        return ans;
    }
} 
