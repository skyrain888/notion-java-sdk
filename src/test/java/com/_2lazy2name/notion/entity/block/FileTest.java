    package com._2lazy2name.notion.entity.block;

import com._2lazy2name.notion.NotionTest;
import com._2lazy2name.notion.entity.block.fileRelated.FileBlock;
import com._2lazy2name.notion.entity.block.fileRelated.ImageBlock;
import com._2lazy2name.notion.entity.block.fileRelated.PdfBlock;
import com._2lazy2name.notion.entity.block.fileRelated.VideoBlock;
import com._2lazy2name.notion.entity.common.file.AbstractFile;
import com._2lazy2name.notion.entity.common.richText.AbstractRichText;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

class FileTest extends NotionTest {
    private final String testPageId = "a7f112c726c9459cbade461e625bad6b";

    @Test
    public void testCreateFileBlock() throws IOException  {
        AbstractFile file = AbstractFile.buildExternalFile(List.of(AbstractRichText.buildPlainText("test")), "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png");
        FileBlock fileBlock = FileBlock.ofFile(file);
       createdBlock.add(notion.appendBlockChild(testPageId, fileBlock).getResult().getId());
    }

    @Test
    public void testCreateImageBlock() throws IOException {
        AbstractFile file = AbstractFile.buildExternalFile(List.of(AbstractRichText.buildPlainText("test")), "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png");
        ImageBlock fileBlock = ImageBlock.ofImage(file);
        createdBlock.add(notion.appendBlockChild(testPageId, fileBlock).getResult().getId());
    }

    @Test
    public void testCreatePdfBlock() throws IOException {
        AbstractFile file = AbstractFile.buildExternalFile("https://www.phocos.com/wp-content/uploads/2021/05/Any-Bridge_chinese-datasheet_2022-08-26.pdf");
        PdfBlock fileBlock = PdfBlock.ofPdf(file);
        createdBlock.add(notion.appendBlockChild(testPageId, fileBlock).getResult().getId());
    }

    @Test
    public void testCreateVideoBlock() throws IOException {
        AbstractFile file = AbstractFile.buildExternalFile("https://a.com/0.mp4");
        VideoBlock fileBlock = VideoBlock.ofVideo(file);
        createdBlock.add(notion.appendBlockChild(testPageId, fileBlock).getResult().getId());
    }



}
