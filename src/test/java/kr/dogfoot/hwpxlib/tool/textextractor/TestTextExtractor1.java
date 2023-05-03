package kr.dogfoot.hwpxlib.tool.textextractor;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.reader.HWPXReader;
import org.junit.Assert;
import org.junit.Test;

public class TestTextExtractor1 {
    @Test
    public void test() throws Exception {
        HWPXFile hwpxFile = HWPXReader.fromFilepath("testFile/tool/textextractor/multipara.hwpx");
        String result = TextExtractor.extract(hwpxFile,
                TextExtractMethod.AppendControlTextAfterParagraphText,
                null,
                false,
                new TextMarks()
                        .lineBreakAnd("\n")
                        .paraSeparatorAnd("\n"));

        String expected = "'어썸킴' 김하성(27·샌디에이고 파드리스)이 시원한 3점홈런을 폭발했다.\n" +
                "\n" +
                "김하성은 2일(이하 한국시간) 미국 캘리포니아주 샌디에이고 펫코파크에서 열린 2023 메이저리그 신시내티 레즈와의 홈 경기에서 7번타자 2루수로 선발 출전했다.\n" +
                "\n" +
                "이날 샌디에이고는 페르난도 타티스 주니어(우익수)-매니 마차도(3루수)-후안 소토(좌익수)-잰더 보가츠(유격수)-맷 카펜터(지명타자)-제이크 크로넨워스(1루수)-김하성(2루수)-트렌트 그리샴(중견수)-브렛 설리반(포수)과 선발투수 블레이크 스넬로 선발 라인업을 구성했다. 신시내티 선발투수는 우완 루크 위버.\n" +
                "\n" +
                "김하성은 1회말 2사 1,3루 찬스에서 유격수 땅볼 아웃으로 물러났지만 4회말 선두타자로 나와 좌전 2루타를 터뜨리면서 득점권 찬스를 열었다. 풀카운트에서 5구째 들어온 위버의 93마일(150km) 포심 패스트볼을 공략한 결과였다. 시즌 5호 2루타. 이어 그리샴의 우전 적시 2루타가 터지면서 득점까지 성공했다. 샌디에이고가 3-3 동점을 이루는 장면이었다.\n" +
                "\n" +
                "\n" +
                "이번엔 역전의 주인공까지 됐다. 3-3 동점이던 샌디에이고의 5회말 공격. 보가츠가 우전 안타를 쳤고 카펜터도 우전 안타로 득점권 찬스를 이끌었다. 크로넨워스가 2루수 직선타 아웃으로 물러나 2사 1,2루 찬스가 고스란히 김하성에게 향했다.\n" +
                "\n" +
                "김하성은 볼카운트 2B 2S에서 좌완투수 알렉스 영의 5구 87마일(140km) 체인지업을 타격했고 타구는 좌측 담장을 넘어가면서 3점홈런이 터졌다. 샌디에이고가 6-3으로 역전하는 한방이었다.\n" +
                "\n" +
                "김하성의 시즌 3호 홈런. 김하성은 지난 4월 10일 애틀랜타 브레이브스전 이후 22일 만에 홈런을 추가했다. 샌디에이고 팬들의 커튼콜을 받은 김하성은 덕아웃에서 나와 두 팔을 벌리고 감사 인사를 표하기도 했다.\n" +
                "\n" +
                "7회말 2사 1루에서는 3구 삼진으로 물러난 김하성은 이날 4타수 2안타 3타점 2득점으로 만족스러운 결과로 경기를 마쳤다. 시즌 타율은 .222로 상승했다. 아울러 메이저리그 통산 100타점을 돌파하는 경사도 맞았다. 이날 경기 전까지 통산 99타점을 기록한 김하성은 홈런 한방으로 3타점을 추가하며 통산 102타점째를 마크했다.\n" +
                "\n" +
                "한편 샌디에이고는 8-3으로 승리하면서 3연승을 질주, 시즌 전적 16승 14패를 기록했으며 김하성의 3점홈런은 결승타로 남았다.";

        Assert.assertEquals(expected, result);
    }
}
