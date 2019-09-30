package logos.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import logos.domain.Bucket;
import logos.domain.Magazine;
import logos.dto.BucketDto;
import logos.service.BucketService;
import logos.service.MagazineService;
import logos.service.impl.BucketServiceImpl;
import logos.service.impl.MagazineServiceImpl;

@WebServlet("/buckets")
public class BucketsController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private BucketService bucketService = BucketServiceImpl.getBucketService();
	private MagazineService magazineService = MagazineServiceImpl.getMagazineService();;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Bucket> buckets = bucketService.readAll();
		Map<Integer, Magazine> idToProduct = magazineService.readAllMap();
		List<BucketDto> listOfBucketDtos = map(buckets, idToProduct);

		String json = new Gson().toJson(listOfBucketDtos);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}

	public List<BucketDto> map(List<Bucket> buckets, Map<Integer, Magazine> idToProduct) {

		return buckets.stream().map(bucket -> {
			BucketDto bucketDto = new BucketDto();
			bucketDto.bucketId = bucket.getId();
			bucketDto.purchaseDate = bucket.getPurchaseDate();

			Magazine magazine = idToProduct.get(bucket.getProductId());
			bucketDto.name = magazine.getTitle();
			bucketDto.category = magazine.getCategory();
			bucketDto.publish_date = magazine.getPublish_date();
			bucketDto.price = magazine.getPrice();

			return bucketDto;
		}).collect(Collectors.toList());

	}
}