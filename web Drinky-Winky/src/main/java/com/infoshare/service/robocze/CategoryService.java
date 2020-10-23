//package com.infoshare.service.robocze;
//
//public class CategoryService {
//    @Stateless
//    public class CategoryService {
//
//        private Logger logger = LoggerFactory.getLogger(getClass().getName());
//
//        @EJB
//        private CategoryDaoBean categoryDaoBean;
//
//        public void save(Category category) {
//            categoryDaoBean.save(category);
//        }
//        @Transactional
//        public Category updateCategory(Category category) {
//            return categoryDaoBean.updateCategory(category);
//        }
//
//        public Category getCategoryById(Long id) {
//            return categoryDaoBean.getCategoryById(id);
//        }
//
//        public List<Category> getCategoriesList() {
//            return categoryDaoBean.getCategoriesList();
//        }
//
//        @Transactional
//        public Category findCategoryByName(String name) {
//            logger.info("ingredients with name contains " + name + " found in database");
//            return categoryDaoBean.findCategoryByName(name);
//        }
//
//        public String[] getCategoryIds() {
//            return categoryDaoBean.getCategoryIds();
//        }
//
//        public List<Category> getCategoriesById(List<Long> ids) {
//            return categoryDaoBean.getCategoriesB
//}
