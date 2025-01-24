package chess.PieceMoves;

import chess.ChessPosition;
import chess.*;

import java.util.ArrayList;
import java.util.Arrays;



// Knights move in an L shape, moving 2 squares in one direction and 1 square in the other direction.
// Knights are the only piece that can ignore pieces in the in-between squares (they can "jump" over other pieces).
// They can move to squares occupied by an enemy piece and capture the enemy piece, or to unoccupied squares.

public class KnightMoves {

    public ArrayList<ChessMove> returnKnightMoves(ChessBoard board, ChessPosition startingPosition, ChessGame.TeamColor myColor) {
        ArrayList<ChessMove> availableMoves = new ArrayList<ChessMove>();
        int startingRow = startingPosition.getRow();
        int startingCol = startingPosition.getColumn();
        ArrayList<int[]> orderedPairs = new ArrayList<>(
                Arrays.asList(
                        new int[]{1, 2},
                        new int[]{-1, 2},
                        new int[]{-1, -2},
                        new int[]{1, -2},

                        new int[]{2, 1},
                        new int[]{-2, 1},
                        new int[]{2, -1},
                        new int[]{-2, -1}
                )
        );

        for (int[] pair : orderedPairs) {

            int row = startingRow + pair[0];
            int col = startingCol + pair[1];
            ChessPosition currPosition = new ChessPosition(row, col);
            if (isAvailableMove(board, currPosition, myColor)) {
                ChessMove currMove = new ChessMove(startingPosition, currPosition, null);
                availableMoves.add(currMove);
            }
        }

        return availableMoves;
    }


    public boolean isAvailableMove(ChessBoard board, ChessPosition currPosition, ChessGame.TeamColor myColor) {

        if (currPosition.getRow() > 8 || currPosition.getRow() < 1 || currPosition.getColumn() > 8 || currPosition.getColumn() < 1) {
            return false;
        }
        ChessPiece piece = board.getPiece(currPosition);
        if (piece != null) {
            return piece.getTeamColor() != myColor;
        }
        return true;
    }

}
