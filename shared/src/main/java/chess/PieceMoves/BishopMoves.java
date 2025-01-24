package chess.PieceMoves;
import chess.*;

import java.util.ArrayList;
import java.util.Arrays;


// Bishops move in diagonal lines as far as there is open space.
// If there is an enemy piece at the end of the diagonal, the bishop
// may move to that position and capture the enemy piece.

// TODO surely theres a better way to do this where you just go up w the row constantly and check within that the col.
public class BishopMoves {
    public ArrayList<ChessMove> bishopMoves(ChessBoard board, ChessPosition startingPosition, ChessGame.TeamColor myColor) {
        ArrayList<ChessMove> availableMoves = new ArrayList<>();
        int row = startingPosition.getRow();
        int col = startingPosition.getColumn();

        // up and right
        while (row < 8 && col < 8) {
            row++;
            col++;
            ChessPosition currPosition = new ChessPosition(row, col);
            if (isAvailableMove(board, currPosition, myColor)) {
                ChessMove currMove = new ChessMove(startingPosition, currPosition, null);
                availableMoves.add(currMove);
            }
        }

        row = startingPosition.getRow();
        col = startingPosition.getColumn();
        // up and left
        while (row < 8 && col > 1) {
            row++;
            col--;
            ChessPosition currPosition = new ChessPosition(row, col);
            if (isAvailableMove(board, currPosition, myColor)) {
                ChessMove currMove = new ChessMove(startingPosition, currPosition, null);
                availableMoves.add(currMove);
            }
        }

        row = startingPosition.getRow();
        col = startingPosition.getColumn();
        while (row < 8 && col > 1) {
            row++;
            col--;
            ChessPosition currPosition = new ChessPosition(row, col);
            if (isAvailableMove(board, currPosition, myColor)) {
                ChessMove currMove = new ChessMove(startingPosition, currPosition, null);
                availableMoves.add(currMove);
            }
        }



        return availableMoves;
    }

    public boolean isAvailableMove(ChessBoard board, ChessPosition currPosition, ChessGame.TeamColor myColor) {
        if (board.getPiece(currPosition) != null) {
            return board.getPiece(currPosition).getTeamColor() != myColor;
        }
        return true;
    }
}
