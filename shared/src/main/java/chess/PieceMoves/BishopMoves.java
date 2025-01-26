package chess.PieceMoves;
import chess.*;

import java.util.ArrayList;
import java.util.Arrays;


// Bishops move in diagonal lines as far as there is open space.
// If there is an enemy piece at the end of the diagonal, the bishop
// may move to that position and capture the enemy piece.

// TODO surely theres a better way to do this where you just go up w the row constantly and check within that the col.
public class BishopMoves {
    public ArrayList<ChessMove> returnBishopMoves(ChessBoard board, ChessPosition startingPosition, ChessGame.TeamColor myColor) {
        ArrayList<ChessMove> availableMoves = new ArrayList<>();
        int startingRow = startingPosition.getRow();
        int startingCol = startingPosition.getColumn();
        int row = startingPosition.getRow();
        int col = startingPosition.getColumn();
        int numToAdd = 1;
        int rowUp = 0;
        int rowDown = 0;
        int colLeft = 0;
        int colRight = 0;

        // while less than 8 greater than one
        // numToAdd++
        // rowUp = staringRow + numToAdd GO UP
        // rowDown = startingRow - numToAdd GO DOWN
        // startingCol + numToAdd  and right
        // do all the checks at this position with the rowUP and the rowDown
        // startingCol - numToAdd    and to the left
        // do the checks again with row up and row down
//
//
//        while (startingRow + numToAdd <= 8 || startingCol + numToAdd <= 8 ||
//               startingRow - numToAdd >= 1 || startingCol - numToAdd >= 1) {
//
//            rowUp = startingRow + numToAdd;
//            rowDown = startingRow - numToAdd;
//            colRight = startingCol + numToAdd;
//            colLeft = startingCol - numToAdd;
//
//            ArrayList<int[]> orderedPairs = new ArrayList<>();
//            if (rowUp <= 8) {
//                if (colRight <= 8) {
//                    orderedPairs.add(new int[]{rowUp, colRight});
//                }
//                if (colLeft >= 1) {
//                    orderedPairs.add(new int[]{rowUp, colLeft});
//                }
//            }
//            if (rowDown >= 1) {
//                if (colRight <= 8) {
//                    orderedPairs.add(new int[]{rowDown, colRight});
//                }
//                if (colLeft >= 1) {
//                    orderedPairs.add(new int[]{rowDown, colLeft});
//                }
//            }
//
//
//
//            for (int[] pair : orderedPairs) {
//                ChessPosition currPosition = new ChessPosition(pair[0], pair[1]);
//                if (isAvailableMove(board, currPosition, myColor)) {
//                    ChessMove currMove = new ChessMove(startingPosition, currPosition, null);
//                    availableMoves.add(currMove);
//                    if (capturesOpponent(board, currPosition, myColor)) {
//                        break;
//                    }
//                }
//            }
//            numToAdd++;
//        }


        row = startingRow;
        col = startingCol;

        // up and right
        while (row < 8 && col < 8) {
            row++;
            col++;
            ChessPosition currPosition = new ChessPosition(row, col);
            if (isAvailableMove(board, currPosition, myColor)) {
                ChessMove currMove = new ChessMove(startingPosition, currPosition, null);
                availableMoves.add(currMove);
                if (capturesOpponent(board, currPosition, myColor)) {
                    break;
                }
            }
            else {
                break;
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
                if (capturesOpponent(board, currPosition, myColor)) {
                    break;
                }
            }
            else {
                break;
            }
        }
        // down right
        row = startingPosition.getRow();
        col = startingPosition.getColumn();
        while (row > 1 && col < 8) {
            row--;
            col++;
            ChessPosition currPosition = new ChessPosition(row, col);
            if (isAvailableMove(board, currPosition, myColor)) {
                ChessMove currMove = new ChessMove(startingPosition, currPosition, null);
                availableMoves.add(currMove);
                if (capturesOpponent(board, currPosition, myColor)) {
                    break;
                }
            }
            else {
                break;
            }
        }


        // down left
        row = startingPosition.getRow();
        col = startingPosition.getColumn();
        while (row > 1 && col > 1) {
            row--;
            col--;
            ChessPosition currPosition = new ChessPosition(row, col);
            if (isAvailableMove(board, currPosition, myColor)) {
                ChessMove currMove = new ChessMove(startingPosition, currPosition, null);
                availableMoves.add(currMove);
                if (capturesOpponent(board, currPosition, myColor)) {
                    break;
                }
            }
            else {
                break;
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
    public boolean capturesOpponent(ChessBoard board, ChessPosition currPosition, ChessGame.TeamColor myColor) {
        if (board.getPiece(currPosition) != null) {
            return board.getPiece(currPosition).getTeamColor() != myColor;
        }
        return false;
    }
}
