/*
package TP1;

import processing.core.PApplet;
import setup.IProcessingApp;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TestCellularAutomata implements IProcessingApp {

    private int nrows = 120;
    private int ncols = 160;
    private int nStates = 4;
    private int radiusNeigh = 1;
    private CellularAutomata ca;
    private boolean startGame = false;

    @Override
    public void setup(PApplet p) {
        ca = new CellularAutomata(p, nrows, ncols, nStates, radiusNeigh);
        ca.initRandom();
        ca.display(p);
    }

    @Override
    public void draw(PApplet p, float dt) {
        ca.display(p);
    }

    */
/*@Override
    public void mousePressed(PApplet p) {
        Cell cell = ca.pixel2Cell(p.mouseX, p.mouseY);
        if (cell.getState() == 1) {
            cell.setState(0);
        } else {
            cell.setState(1);
        }
    }*//*


    @Override
    public void mousePressed(PApplet p) {
        for (int i = 0; i < nrows; i++) {
            for (int j = 0; j < ncols; j++) {
                Cell cell = ca.cellCoords(i,j);
                if (ca.countNeighbors(cell) > 3 || ca.countNeighbors(cell) < 2) {
                    cell.setState(0);
                } else {
                    cell.setState(1);
                }
            }
        }

    }

    @Override
    public void keyPressed(PApplet p) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            startGame = true;
        }
    }

}
*/
