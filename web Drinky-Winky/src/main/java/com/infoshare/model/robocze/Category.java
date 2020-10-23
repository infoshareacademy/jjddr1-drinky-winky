//package com.infoshare.model.robocze;
//
//public class Category {
//
//
//    @Entity
//    @Table(name = "category", indexes = {@Index(name = "category_name", columnList = "name")})
//    public class Category {
//
//        @Id
//        @Column(name = "id")
//        @GeneratedValue(strategy = GenerationType.IDENTITY)
//        private Long id;
//
//        @Column(name = "name", unique = true, length = 50)
//        @NotNull
//        private String name;
//
//        @OneToOne(mappedBy = "category")
//        private RecipeStatistics recipeStatistics;
//
//        @OneToMany(mappedBy = "category", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//        private List<Recipe> recipes = new ArrayList<>();
//
//        public Long getId() {
//            return id;
//        }
//
//        public void setId(Long id) {
//            this.id = id;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public List<Recipe> getRecipes() {
//            return recipes;
//        }
//
//        public void setRecipes(List<Recipe> recipes) {
//            this.recipes = recipes;
//        }
//
//        public RecipeStatistics getRecipeStatistics() {
//            return recipeStatistics;
//        }
//
//        public void setRecipeStatistics(RecipeStatistics recipeStatistics) {
//            this.recipeStatistics = recipeStatistics;
//        }
//    }
//}
