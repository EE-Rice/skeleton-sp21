package game2048;

/** Represents the image of a numbered tile on a 2048 board.
 *  @author P. N. Hilfinger.
 */
// 表示2048棋盘上带数字方块的图像。
public class Tile {

    /** A new tile with VALUE as its value at (ROW, COL).  This
     *  constructor is private, so all tiles are created by the
     *  factory methods create, move, and merge. */
    /** 创建一个值为VALUE的新方块，位于(ROW, COL)。
     *  这个构造函数是私有的，所以所有方块都由工厂方法create、move和merge创建。 */
    private Tile(int value, int col, int row) {
        this.value = value;
        this.row = row;
        this.col = col;
        this.next = null;
    }

    /** Return my current row. */
    public int row() {
        return row;
    }

    /** Return my current column. */
    public int col() {
        return col;
    }

    /** Return the value supplied to my constructor. */
    public int value() {
        return value;
    }

    /** Return my next state.  Before I am moved or merged, I am my
     *  own successor. */
    /** 返回我的下一个状态。在我被移动或合并之前，我是我自己的后继者。 */
    public Tile next() {
        return next == null ? this : next;
    }

    /** Return a new tile at (ROW, COL) with value VALUE. */
    /** 在(COL, ROW)处创建一个值为VALUE的新方块。 */
    public static Tile create(int value, int col, int row) {
        return new Tile(value, col, row);
    }

    /** Return the result of moving me to (COL, ROW). */
    /** 返回将我移动到(COL, ROW)的结果。 */
    public Tile move(int col, int row) {
        Tile result = new Tile(value, col, row);
        next = result;
        return result;
    }

    /** Return the result of merging OTHERTILE with me after moving to
     *  (COL, ROW). */
    /** 返回将我移动到(COL, ROW)后与OTHERTILE合并的结果。 */
    public Tile merge(int col, int row, Tile otherTile) {
        assert value == otherTile.value();
        next = otherTile.next = new Tile(2 * value, col, row);
        return next;
    }

    /** Return the distance in rows or columns between me and my successor
     *  tile (0 if I have no successor). */
    /** 返回我与后继方块之间的行或列距离（如果没有后继则返回0）。 */
    public int distToNext() {
        if (next == null) {
            return 0;
        } else {
            return Math.max(Math.abs(row - next.row()),
                            Math.abs(col - next.col()));
        }
    }

    @Override
    public String toString() {
        return String.format("%d@(%d, %d)", value(), col(), row());
    }

    /** My value. */
    /** 我的值。 */
    private final int value;

    /** My last position on the board. */
    /** 我在棋盘上的最后位置。 */
    private final int row, col;

    /** Successor tile: one I am moved to or merged with. */
    /** 后继方块：我移动或合并到的方块。 */
    private Tile next;
}
