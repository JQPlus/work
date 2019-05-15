package cn.bugging.work;

import java.util.ArrayList;
import java.util.List;

import cn.bugging.work.dao.DetailDao;
import cn.bugging.work.entity.DetailEntity;
import cn.bugging.work.entity.PriorityEntity;
import cn.bugging.work.entity.StatusEntity;
import cn.bugging.work.entity.TypeEntity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class DetailMapperTest {
	/**
	 * @author HuangJq
	 * @Description
	 * 
	 */
	@Autowired
	private DetailDao detailDao;

//	@Test
//	public void getListTest() throws IllegalArgumentException, IllegalAccessException
//	{
//		List<DetailEntity> originList=new ArrayList<>();
//		List<DetailEntity> resultList=new ArrayList<>();
//		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		originList=detailDao.getAllDetail();
//		for(DetailEntity detail : originList)
//		{
////			System.out.println(detail.getStatusID());
//			detail.setStatusName(detailDao.getStatusNameByID(detail.getStatusID()));
//			detail.setTypeName(detailDao.getTypeNameByID(detail.getTypeID()));
//			detail.setPriorityName(detailDao.getPriorityNameByID(detail.getPriorityID()));
////			detail.setCreatetime(dateFormat.format(detail.getCreatetime()));
//			resultList.add(detail);
//		}
//
//		DetailEntity test=resultList.get(0);
//		System.out.println(test.getCreatetime());
////		Class clas=test.getClass();
////		Field[] field=clas.getDeclaredFields();
////		for(Field f : field)
////		{
////			f.setAccessible(true);
////			System.out.println("属性名:"+f.getName()+"属性值"+f.get(test));
////		}
//	}
//    @Test
////    @Rollback(true)
//    public void insertTest()
//    {
//    	DetailEntity detailEntity=new DetailEntity();
//    	detailEntity.setID("20");
//    	detailEntity.setBelongto("test");
//    	detailDao.insert(detailEntity);
//    }

//    @Test
//    public void delete()
//    {
//    	detailDao.delete("20");
//    }
//    
//    @Test
//    @Rollback(false)
//    public void update()
//    {
//    	//try catch 如果id不存在 报错
//    	DetailEntity detailEntity=new DetailEntity();
//    	detailEntity.setID("2");
//    	detailEntity.setBelongto("test update");
//    	detailEntity.setBrief("brief");
//    	detailDao.update(detailEntity);
//    }
//	@Test
//	public void test() throws IllegalArgumentException, IllegalAccessException {
//		List<PriorityEntity> list = detailDao.getPriorityInfo();
//		List<StatusEntity> list1 = detailDao.getStatusInfo();
//		List<TypeEntity> list2 = detailDao.getTypeInfo();
//		System.out.println(list1.size());
//		System.out.println(list2.size());
//	}
}
