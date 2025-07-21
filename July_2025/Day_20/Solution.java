import java.util.*;

class Solution {
    static class Node {
        String name;
        TreeMap<String, Node> children;
        String signature;

        public Node(String name) {
            this.name = name;
            this.children = new TreeMap<>();
        }
    }

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        Node root = new Node("");
        for (List<String> path : paths) {
            Node curr = root;
            for (String folder : path) {
                curr.children.putIfAbsent(folder, new Node(folder));
                curr = curr.children.get(folder);
            }
        }

        Map<String, Integer> countMap = new HashMap<>();
        dfs(root, countMap);

        List<List<String>> result = new ArrayList<>();
        List<String> currentPath = new ArrayList<>();
        for (Node child : root.children.values()) {
            dfs2(child, currentPath, result, countMap);
        }
        return result;
    }

    private void dfs(Node node, Map<String, Integer> countMap) {
        if (node.children.isEmpty()) {
            node.signature = "";
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Node child : node.children.values()) {
            dfs(child, countMap);
            sb.append(child.name).append('(').append(child.signature).append(')');
        }
        node.signature = sb.toString();
        countMap.put(node.signature, countMap.getOrDefault(node.signature, 0) + 1);
    }

    private void dfs2(Node node, List<String> currentPath, List<List<String>> result, Map<String, Integer> countMap) {
        if (!node.children.isEmpty() && countMap.getOrDefault(node.signature, 0) >= 2) {
            return;
        }
        currentPath.add(node.name);
        result.add(new ArrayList<>(currentPath));
        for (Node child : node.children.values()) {
            dfs2(child, currentPath, result, countMap);
        }
        currentPath.remove(currentPath.size() - 1);
    }
} 
