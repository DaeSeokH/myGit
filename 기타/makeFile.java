package study;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

// 기존 mybatis에서 tibero를 사용했는데 추가적으로 oracle 폴더 생성 후 오라클도 사용하려고한다.
// 업무로직폴더명/dao/maps/tibero가 업무별로 폴더들이 있는 상태. 
// 각 maps 안에 oracle 폴더 생성 후 tibero 폴더의 mapper.xml을 모두 복사해서 oracle 폴더안에 넣는다.
public class makeFile {
    public static void main(String[] args) {
        // 주어진 디렉토리 경로
        String rootDirectoryPath = "경로입력";
        createOracleFolders(rootDirectoryPath);
    }
    public static void createOracleFolders(String directoryPath) {
        File directory = new File(directoryPath);
        // 디렉토리가 존재하는지 확인
        if (!directory.exists()) {
            System.err.println("디렉토리가 존재하지 않습니다: " + directoryPath);
            return;
        }
        // 디렉토리 내의 파일 및 서브 디렉토리 목록 가져오기
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // 서브 디렉토리인 경우 재귀적으로 호출
                    createOracleFolders(file.getAbsolutePath());
                }
                // "maps" 폴더가 있는 디렉토리인 경우
                if (file.isDirectory() && file.getName().equals("maps")) {
                    // "oracle" 폴더 경로 생성
                    File oracleFolder = new File(file.getAbsolutePath() + File.separator + "oracle");
                    if (!oracleFolder.exists()) {
                        boolean created = oracleFolder.mkdirs();
                        if (created) {
                            System.out.println("폴더가 생성되었습니다: " + oracleFolder.getAbsolutePath());
                        } else {
                            System.err.println("폴더 생성에 실패했습니다: " + oracleFolder.getAbsolutePath());
                        }
                    }
                    // "tibero" 폴더의 내용을 "oracle" 폴더로 복사
                    File tiberoFolder = new File(file.getAbsolutePath() + File.separator + "tibero");
                    if (tiberoFolder.exists()) {
                        File[] tiberoFiles = tiberoFolder.listFiles();
                        if (tiberoFiles != null) {
                            for (File tiberoFile : tiberoFiles) {
                                try {
                                    Path source = tiberoFile.toPath();
                                    Path destination = new File(oracleFolder.getAbsolutePath() + File.separator + tiberoFile.getName()).toPath();
                                    Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
                                    System.out.println("파일이 복사되었습니다: " + destination);
                                } catch (IOException e) {
                                    System.err.println("파일 복사 중 오류가 발생했습니다: " + e.getMessage());
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
