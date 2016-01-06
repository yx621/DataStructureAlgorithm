public class SuffixTree
{
    public class SuffixTreeNode
    {
        HashMap<Character, SuffixTreeNode> children = new HashMap<Character, SuffixTreeNode>();

        char value;

        ArrayList<Integer> indexes = new ArrayList<Integer>();

        public SuffixTreeNode()
        {

        }

        public void insertString(String s, int index)
        {
            indexes.add(index);
            if (s != null && s.length() > 0)
            {
                value = s.charAt(0);
                SuffixTreeNode child = null;

                if (children.containsKey(value))
                {
                    child = children.get(value);
                }

                else
                {
                    child = bew SuffixTreeNode();
                    children.put(value, child);
                }

                String remainder = s.substring(1);
                child.insertString(remainder, index);
            }
        }

        public ArrayList<Integer> getIndexes(String s)
        {
            if (s == null || s.length() == 0)
            {
                return indexes;
            }

            else
            {
                char first = s.charAt(0);
                if (children.containsKey(first))
                {
                    String remainder = s.substring(1);
                    return children.get(first).getIndexes(remainder);
                }
            }
            return null;
        }

    }

    public class SuffixTree
    {
        SuffixTreeNode root = new SuffixTreeNode();

        public SuffixTree(String s)
        {
            for (int nIndex = 0; nIndex < s.length(); ++nIndex)
            {
                String suffix = s.substring(nIndex);
                root.insertString(suffix, nIndex);
            }
        }

        public ArrayList<Integer> getIndexes(String s)
        {
            return root.getIndexes(s);
        }
    }

    public static void main(String[] args) 
    {
        
    }
}