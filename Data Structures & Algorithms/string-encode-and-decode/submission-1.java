class Solution {

    public String encode(List<String> strs) {

        if(strs.size() == 0) {
            return "";
        }

        List<Integer> sizes = new ArrayList<>();

        for(String str: strs) {
            sizes.add(str.length());
        }

        String sizesHeader = sizes.stream()
            .map(i -> Integer.toString(i))
            .collect(Collectors.joining(",")) + "#";
        
        String contentStr = strs.stream().collect(Collectors.joining());

        return sizesHeader + contentStr;
    }

    public List<String> decode(String str) {

        if(str.equalsIgnoreCase("")) {
            return new ArrayList<String>();
        }

        int indexOfHeader = str.indexOf((int) '#', 0);
        String sizesHeader = str.substring(0, indexOfHeader);
        List<Integer> sizes = Arrays.stream(sizesHeader.split(",")).mapToInt(s -> Integer.parseInt(s)).boxed().toList();

        List<String> decoded = new ArrayList<>();
        String contentStr = str.substring(indexOfHeader+1);
        for(Integer size: sizes) {
            String decodedStr = contentStr.substring(0, size);
            decoded.add(decodedStr);
            contentStr = contentStr.substring(size);
        }

        return decoded;
    }
}
