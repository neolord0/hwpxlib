package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;

import java.util.ArrayList;

/**
 * 변환 정보
 *      transMatrix, scaMatrix, rotMatrix 가 2개 이상 나올 수 있다.
 */
public class RenderingInfo extends SwitchableObject {

    private ArrayList<Matrix> matrixList;


    public RenderingInfo() {
        matrixList = new ArrayList<Matrix>();
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_renderingInfo;
    }

    public int countOfMatrix() {
        return matrixList.size();
    }

    public Matrix getMatrix(int index) {
        return matrixList.get(index);
    }

    public int getMatrixIndex(Matrix matrix) {
        int count = matrixList.size();
        for (int index = 0; index < count; index++) {
            if (matrixList.get(index) == matrix) {
                return index;
            }
        }
        return -1;
    }

    public void addMatrix(Matrix matrix) {
        matrixList.add(matrix);
    }

    public Matrix addNewTransMatrix() {
        Matrix transMatrix = new Matrix(ObjectType.hc_transMatrix);
        matrixList.add(transMatrix);
        return transMatrix;
    }

    public Matrix addNewScaMatrix() {
        Matrix scaMatrix = new Matrix(ObjectType.hc_scaMatrix);
        matrixList.add(scaMatrix);
        return scaMatrix;
    }

    public Matrix addNewRotMatrix() {
        Matrix rotMatrix = new Matrix(ObjectType.hc_rotMatrix);
        matrixList.add(rotMatrix);
        return rotMatrix;
    }

    public void insertMatrix(Matrix matrix, int position) {
        matrixList.add(position, matrix);
    }

    public void removeMatrix(int position) {
        matrixList.remove(position);
    }

    public void removeMatrix(Matrix matrix) {
        matrixList.remove(matrix);
    }

    public void removeAllMatrix() {
        matrixList.clear();
    }

    public Iterable<Matrix> matrices() {
        return matrixList;
    }

    @Override
    public RenderingInfo clone() {
        RenderingInfo cloned = new RenderingInfo();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(RenderingInfo from) {
        for (Matrix matrix : from.matrixList) {
            matrixList.add(matrix.clone());
        }

        super.copyFrom(from);
    }
}
