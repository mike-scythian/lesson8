package nix.lessons;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MatrixTest {

    @Test
    void shouldTranspose(){

        int[][] matrix = { {1,2,3}, {4,5,6} };
        int[][] tMatrix = {{1,4}, {2,5}, {3,6}};

        assertThat(Matrix.transpose(matrix)).isEqualTo(tMatrix);
    }
}