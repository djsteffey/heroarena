package djs.game.heroarena;


public class Tilemap {
    public enum ETilemapTileType{
        FLOOR,
        WALL
    }

    public class TilemapTile{
        // variables
        private ETilemapTileType m_type;

        // methods
        public TilemapTile(ETilemapTileType type){
            this.m_type = type;
        }

        public ETilemapTileType get_type(){
            return this.m_type;
        }
    }

    // variables
    private int m_width;
    private int m_height;
    private TilemapTile m_tiles[][];

    // methods
    public Tilemap(int width, int height){
        this.m_width = width;
        this.m_height = height;
        this.m_tiles = new TilemapTile[this.m_width][this.m_height];
        for (int y = 0; y < this.m_height; ++y){
            for (int x = 0; x < this.m_width; ++x){
                this.m_tiles[x][y] = new TilemapTile(ETilemapTileType.FLOOR);
            }
        }
    }

    public int get_width(){
        return this.m_width;
    }

    public int get_height(){
        return this.m_height;
    }

    public TilemapTile get_tile(int x, int y){
        return this.m_tiles[x][y];
    }
}
