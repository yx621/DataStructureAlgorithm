public class memoryFile
{
    struct DabaBlock
    {
        char data[DATA_BLOCK_SIZE];
    }

    DataBlock dataBlocks[NUM_DATA_BLOCKS];

    struct INode 
    {
        vector<int> datablocks;
    }

    struct MetaData
    {
        int size;
        Data last_modified, created;
        char extra_attributes;
    }

    vector<bool> dataBlockUsed(NUM_DATA_BLOCKS);

    map<string, INode> mapFromName;
    struct FSBase;

    struct File : public FSBase
    {
        
    }
}